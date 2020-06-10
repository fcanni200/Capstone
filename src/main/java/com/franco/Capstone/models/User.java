package com.franco.Capstone.models;


import org.springframework.lang.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {

     @NonNull
     private String username;

     @NonNull
     private String pwHash;

     @OneToMany(mappedBy = "owner")
     private List<Vehicle> vehicles = new ArrayList<>();

     private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

     public User() {}

     public User (String username, String password) {
          this.username = username;
          this.pwHash = encoder.encode(password);
     }

     public List<Vehicle> getVehicles() {
          return vehicles;
     }

     public void setVehicle(Vehicle vehicle) {
          this.vehicles.add(vehicle);
     }

     public String getUsername() {
          return username;
     }

     public boolean isMatchingPassword(String password) {
          return encoder.matches(password, pwHash);
     }



}