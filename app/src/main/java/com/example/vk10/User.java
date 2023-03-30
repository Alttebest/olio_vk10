package com.example.vk10;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable, Comparable<User>{
    private String firstName = "Etunimi";
    private String lastName = "Sukunimi";
    private String email = "Sähköpostiosoite";
    private String degreeProgram;
    private ArrayList<String> degrees = new ArrayList<>();

    public User(String firstName, String lastName, String email, String degreeProgram, ArrayList<String> degrees){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.degrees = degrees;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getDegreeProgram(){
        return degreeProgram;
    }
    public ArrayList<String> getCompletedDegrees(){
        return degrees;
    }

    @Override
    public int compareTo(User otherUser) {
        return this.lastName.compareTo(otherUser.getLastName());
    }
}
