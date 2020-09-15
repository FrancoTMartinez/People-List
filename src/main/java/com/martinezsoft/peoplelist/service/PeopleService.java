package com.martinezsoft.peoplelist.service;

import com.martinezsoft.peoplelist.database.HibernateSessionFactory;
import com.martinezsoft.peoplelist.model.People;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class PeopleService {
    private HibernateSessionFactory hibernateSessionFactory;
    private Session peopleSession;

    public PeopleService(HibernateSessionFactory hibernateSessionFactory) throws Exception {
        this.hibernateSessionFactory = hibernateSessionFactory;
        peopleSession = hibernateSessionFactory.buildSession();
    }

    //get people by Id
    public People getPeople(String id){
        return peopleReturnedFromDataBase(id);
    }
    //get all people
    public List<People> getPeople(){
        peopleSession.beginTransaction();
        List<People> peopleList = peopleSession.createQuery("from People", People.class).list();
        peopleSession.getTransaction().commit();
        return peopleList;
    }

    public People addPeople(People people){
        peopleSession.beginTransaction();
        peopleSession.save(people);
        peopleSession.getTransaction().commit();
        return people;
    }

    public People updatePeople (String id, People people){
        People peopleReturned = peopleReturnedFromDataBase(id);
        peopleReturned.setName(people.getName());
        peopleReturned.setDate(people.getDate());
        peopleReturned.setAdress(people.getAdress());
        peopleReturned.setEmail(people.getEmail());
        peopleReturned.setPhone(people.getPhone());
        return peopleReturned;
    }

    public void deletePeople (String id){
        peopleSession.delete(peopleReturnedFromDataBase(id));
        peopleSession.getTransaction().commit();
    }

    private People peopleReturnedFromDataBase (String id){
        People peopleReturned;
        try{
            peopleSession.beginTransaction();
            Query selectQuery = peopleSession.createQuery("from People WHERE Id=:paramId");
            selectQuery.setParameter("paramId", id);
            peopleReturned = (People) selectQuery.uniqueResult();
            return peopleReturned;
        }catch(EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
