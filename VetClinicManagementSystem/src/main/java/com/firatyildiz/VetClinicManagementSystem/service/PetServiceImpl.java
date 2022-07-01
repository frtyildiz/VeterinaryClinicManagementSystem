package com.firatyildiz.VetClinicManagementSystem.service;

import com.firatyildiz.VetClinicManagementSystem.entity.Pet;
import com.firatyildiz.VetClinicManagementSystem.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PetServiceImpl implements PetService{

    @Autowired
    PetRepository petRepository;

    public Pet findPetById(Long id)
    {
        return petRepository.findById(id).get();
    }

    public List<Pet> findAllPets()
    {
        return petRepository.findAll();
    }

    public Pet createPet (Pet pet)
    {
        return petRepository.save(pet);
    }

    public Pet updataPet (Pet pet)
    {
        return petRepository.save(pet);
    }

    public void deletePet (Pet pet)
    {
        petRepository.delete(pet);
    }
}
