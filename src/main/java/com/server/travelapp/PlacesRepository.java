package com.server.travelapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

interface PlacesRepository extends JpaRepository<Places, Long> {
    Collection<Places> findPlacesName(String placeName);
}
