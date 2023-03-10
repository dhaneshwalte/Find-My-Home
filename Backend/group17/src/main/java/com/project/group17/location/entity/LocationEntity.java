package com.project.group17.location.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "city_locations")
public class LocationEntity {
    
    @Id
    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    String latitude;

    @Column(nullable = false)
    String longitude;   

    public LocationEntity(){}

    public LocationEntity(String city, String latitude, String longitude) {
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
