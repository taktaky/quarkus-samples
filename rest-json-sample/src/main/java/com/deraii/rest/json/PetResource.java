package com.deraii.rest.json;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/pets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PetResource {

    private final Set<Pet> pets = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public PetResource() {
        pets.add(new Pet("ムギ",  "犬：トイプードル"));
        pets.add(new Pet("サクラ", "犬：チワワ"));
        pets.add(new Pet("ハッピー",  "犬：ミックス犬"));
    }

    @GET
    public Set<Pet> list() {
        return pets;
    }

    @POST
    public Set<Pet> add(Pet pet) {
        pets.add(pet);
        return pets;
    }

    @DELETE
    public Set<Pet> delete(Pet pet) {
        pets.removeIf(existingPet -> existingPet.name.contentEquals(pet.name));
        return pets;
    }
}