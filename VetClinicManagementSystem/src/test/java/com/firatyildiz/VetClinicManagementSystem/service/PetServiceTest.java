package com.firatyildiz.VetClinicManagementSystem.service;

import com.firatyildiz.VetClinicManagementSystem.entity.Pet;
import com.firatyildiz.VetClinicManagementSystem.repository.PetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    @InjectMocks
    PetServiceImpl petService;

    @Mock
    PetRepository petRepository;

    @Test
    void findPetByIdTest()
    {
        Pet petMock = mock(Pet.class);
        petMock.setId(1);
        petMock.setName("test");
        petMock.setSpecies("test");
        petMock.setType("test");

        when(petRepository.findById(petMock.getId())).thenReturn(Optional.of(petMock));
        Pet findPet = petService.findPetById(petMock.getId());

        assertEquals(petMock, findPet);
    }

    @Test
    void findAllPetsTest()
    {
        Pet petMock = mock(Pet.class);
        petMock.setId(1);
        petMock.setName("test");
        petMock.setSpecies("test");
        petMock.setType("test");

        List<Pet> pets = new ArrayList<>();
        pets.add(petMock);

        when(petRepository.findAll()).thenReturn(pets);
        List<Pet> petList = petService.findAllPets();

        assertEquals(pets, petList);
    }

    @Test
    void createPetTest()
    {
        Pet petMock = mock(Pet.class);
        petMock.setId(1);
        petMock.setName("test");
        petMock.setSpecies("test");
        petMock.setType("test");

        when(petRepository.save(petMock)).thenReturn(petMock);
        Pet pet = petService.createPet(petMock);

        assertEquals(pet, petMock);
    }

    @Test
    void updataPetTest()
    {
        Pet petMock = mock(Pet.class);
        petMock.setId(1);
        petMock.setName("test");
        petMock.setSpecies("test");
        petMock.setType("test");

        when(petRepository.save(petMock)).thenReturn(petMock);
        Pet pet = petService.updataPet(petMock);

        assertEquals(pet, petMock);
    }
}