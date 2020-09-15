package com.martinezsoft.peoplelist.configuration;

import com.martinezsoft.peoplelist.database.HibernateSessionFactory;
import com.martinezsoft.peoplelist.service.PeopleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class PeopleListConfiguration {

    @Bean
    @RequestScope
    public PeopleService peopleService() throws Exception {return new PeopleService(hibernateSessionFactory());}

    @Bean
    @RequestScope
    public HibernateSessionFactory hibernateSessionFactory() {
        return new HibernateSessionFactory();
    }
}
