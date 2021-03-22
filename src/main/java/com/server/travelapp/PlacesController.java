package com.server.travelapp;


import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class PlacesController {

    private final PlacesRepository repository;

    private final PlacesModelAssembler assembler;



    PlacesController(PlacesRepository repository, PlacesModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/places")
    Collection<EntityModel<Places>> all() {

        List<EntityModel<Places>> places = repository.findAll().stream()
                .map(assembler ::toModel)
                .collect(Collectors.toList());

        return (Collection<EntityModel<Places>>) CollectionModel.of(places, linkTo(methodOn(PlacesController.class).all()).withSelfRel());
    }


    @GetMapping("/places/{id}")
    EntityModel<Places> one(@PathVariable Long id) {

        Places places = repository.findById(id).orElseThrow(() -> new PlacesNotFoundException(id));

        return assembler.toModel(places);
    }

    private PlacesController methodOn(Class<PlacesController> placesControllerClass) {
        return null;
    }


}

