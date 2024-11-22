package com.example;
import java.io.File;
public class Person {
    String name, fatherName, cnic, gender, city;
    String dateOfBirth;
    File imageFile;

    public Person(String name, String fatherName, String cnic, String dateOfBirth, String gender, String city, File imageFile) {
        this.name = name;
        this.fatherName = fatherName;
        this.cnic = cnic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.city = city;
        this.imageFile = imageFile;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Father Name: " + fatherName + ", CNIC: " + cnic + ", Date of Birth: " + dateOfBirth +
                ", Gender: " + gender + ", City: " + city + ", Image: " + (imageFile != null ? imageFile.getName() : "No Image");
    }
}