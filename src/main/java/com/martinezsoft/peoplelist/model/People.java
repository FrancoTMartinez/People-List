package com.martinezsoft.peoplelist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "People")
public class People {

    @JsonProperty("peopleId")
    @Id
    @Column(name = "ID")
    private String id = null;

    @JsonProperty("peopleName")
    @Column(name ="NAME")
    private String name = null;

    @JsonProperty("peopleDate")
    @Column(name ="PEOPLE_DATE")
    private String date = null;

    @JsonProperty("peopleAddress")
    @Column(name ="ADDRESS")
    private String address = null;

    @JsonProperty("peopleEmail")
    @Column(name ="EMAIL")
    private String email = null;

    @JsonProperty("peoplePhone")
    @Column(name ="PHONE")
    private String phone = null;

    public People(String id, String name, String date, String adress, String email, String phone) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.address = adress;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return id.equals(people.id) &&
                name.equals(people.name) &&
                date.equals(people.date) &&
                address.equals(people.address) &&
                email.equals(people.email) &&
                phone.equals(people.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, address, email, phone);
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", adress='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
