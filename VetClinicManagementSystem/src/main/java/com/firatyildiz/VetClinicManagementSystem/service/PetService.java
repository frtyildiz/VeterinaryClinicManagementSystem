package com.firatyildiz.VetClinicManagementSystem.service;

import com.firatyildiz.VetClinicManagementSystem.entity.Pet;

import java.util.List;

public interface PetService {

    Pet findPetById(Long id);

    List<Pet> findAllPets();

    Pet createPet (Pet pet);

    Pet updataPet (Pet pet);

    void deletePet (Pet pet);
}
