package com.dimemtl;

import java.time.LocalDate;
import java.util.Objects;

public class Student {
    String fistName;
    String lastName;
    LocalDate birthday;

    public Student(){

    }

    public Student(String fistName, String lastName, LocalDate birthday) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(fistName, student.fistName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(birthday, student.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fistName, lastName, birthday);
    }

    @Override
    public String toString() {
        return "Student{" +
                "fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

