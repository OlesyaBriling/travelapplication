package com.server.travelapp;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class PlacesModelAssembler implements RepresentationModelAssembler<Places, EntityModel<Places>> {

    public PlacesModelAssembler() {

    }

    @Override
    public EntityModel<Places> toModel(Places place) {

        return EntityModel.of(place, //
                linkTo(methodOn(PlacesController.class).one(place.getId())).withSelfRel(),
                linkTo(methodOn(PlacesController.class).all()).withRel("places"));
    }
}
