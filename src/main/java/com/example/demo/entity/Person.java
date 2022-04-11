package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Person {
    @EmbeddedId
    private PersonData personData;
    private String phoneNumber;
    private String city;

    public Person() {
    }

    public PersonData getPersonData() {
        return personData;
    }

    public void setPersonData(PersonData personData) {
        this.personData = personData;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personData=" + personData +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    private static class Builder {
        private final Person person = new Person();

        public Builder personData(PersonData personData) {
            person.personData = personData;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            person.phoneNumber = phoneNumber;
            return this;
        }

        public Builder city(String city) {
            person.city = city;
            return this;
        }
        public Person build(){
            return person;
        }

    }

    public Person initBuilder(PersonData personData, String phoneNumber, String city){
        return new Person.Builder()
                .personData(personData)
                .phoneNumber(phoneNumber)
                .city(city)
                .build();
    }
    @Embeddable
    public static class PersonData implements Serializable {
        private String name;
        private String surname;
        @Column(nullable = false)
        private int age;

        public PersonData(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        public PersonData() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PersonData that = (PersonData) o;
            return age == that.age && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname, age);
        }

        @Override
        public String toString() {
            return "PersonData{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
