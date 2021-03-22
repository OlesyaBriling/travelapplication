package com.server.travelapp;

import org.springframework.data.jpa.repository.JpaRepository;


interface PlacesRepository extends JpaRepository<Places, Long> {

}
