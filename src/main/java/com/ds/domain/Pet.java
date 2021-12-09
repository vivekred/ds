package com.ds.domain;

import java.util.Date;

public class Pet {

    String name;
    String owner;
    String species;


    public Pet( String name, String owner, String species) {
        this.name = name;
        this.owner = owner;
        this.species = species;

    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
