package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;

    @Column(nullable = false)
    private int age;

    private String phone_number;
    private String city;

    public Person() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static class Builder {
        private Person person;

        public Builder() {
            person = new Person();
        }

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

        public Builder phone_number(String phone_number) {
            person.phone_number = phone_number;
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

    public Person(int id, String name, String surname, int age, String phone_number, String city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone_number = phone_number;
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
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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
                ", phone_number='" + phone_number + '\'' +
                ", city_of_living='" + city + '\'' +
                '}';
    }
}
