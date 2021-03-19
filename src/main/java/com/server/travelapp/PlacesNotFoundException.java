package com.server.travelapp;

public class PlacesNotFoundException extends RuntimeException {

    PlacesNotFoundException(Long id) {
        super("Could not found place" + id);
    }
}
