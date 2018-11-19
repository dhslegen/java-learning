package javaStudy.java.lamada表达式学习;

import java.time.LocalDate;
import java.util.List;

public class Person {

    public static List<Person> createRoster() {
        return null;
    }

    public enum Sex {
        MALE, FEMALE
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        return 0;
    }

    public void printPerson() {
        System.out.println("hello:" + name);
    }
}