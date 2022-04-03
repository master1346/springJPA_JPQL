package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Person {
    private int id;
    @Id
    private String name;
    @Id
    private String surname;
    @Id
    @Column(nullable = false)
    private int age;

    private String phoneNumber;
    private String city;

    public Person() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person(int id, String name, String surname, int age, String phoneNumber, String city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone_number() {
        return phoneNumber;
    }

    public void setPhone_number(String phone_number) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity_of_living() {
        return city;
    }

    public void setCity_of_living(String city_of_living) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phone_number='" + phoneNumber + '\'' +
                ", city_of_living='" + city + '\'' +
                '}';
    }

    private static class Builder {
        private final Person person = new Person();

        public Builder name(String name) {
            person.name = name;
            return this;
        }

        public Builder surname(String surname) {
            person.surname = surname;
            return this;
        }

        public Builder age(int age) {
            person.age = age;
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

    public Person initBuilder(String name, String surname, int age, String phoneNumber, String city){
        return new Person.Builder()
                .name(name)
                .surname(surname)
                .age(age)
                .phoneNumber(phoneNumber)
                .city(city)
                .build();
    }
}
