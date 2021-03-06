package com.franco.Capstone.models;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Vehicle extends AbstractEntity {

    @NotNull
    @Size(min=3, max=50)
    private String make;
    private String model;
    private String year;
    private String imageLink;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User owner;

    public Vehicle(){
    }

    public Vehicle(String aMake, String aModel, String someYear, User owner, String imageLink) {
        super();
        this.make = aMake;
        this.model = aModel;
        this.year = someYear;
        this.owner = owner;
        this.imageLink = imageLink;
    }

    public static Object getAll() {
        return null;
    }

    public static void remove(int id) {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public String toString(){
        return make;
    }
}
