package com.franco.Capstone.models;


import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Vehicle extends AbstractEntity {

    @NotNull
    @Size(min=3, max=50)
    private String make;
    private String model;
    private String year;

    public Vehicle(){
    }

    public Vehicle(String aMake, String aModel, String someYear) {
        super();
        this.make = aMake;
        this.model = aModel;
        this.year = someYear;
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

    @Override
    public String toString(){
        return make;
    }
}
