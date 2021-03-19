package com.server.travelapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Places {

    @Id
    @GeneratedValue

    private String placeName;
    @Id
    @GeneratedValue
    private Long id;

    public Places(String placeName) {
        this.placeName = placeName;
    }

    public Places() {
    }

    public Long getId() {
        return id;
    }

    public String getPlaceName() {
        return placeName;
    }

//	public void setId(Long id) {
//		this.id = id;
//	}


    @Override
    public String toString() {
        return "Places{" +
                "placeName='" + placeName + '\'' +
                ", id=" + id +
                '}';
    }
}
