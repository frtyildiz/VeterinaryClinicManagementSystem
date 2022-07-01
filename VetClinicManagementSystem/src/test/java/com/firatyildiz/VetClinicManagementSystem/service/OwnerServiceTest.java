package com.firatyildiz.VetClinicManagementSystem.service;

import com.firatyildiz.VetClinicManagementSystem.entity.Owner;
import com.firatyildiz.VetClinicManagementSystem.entity.Pet;
import com.firatyildiz.VetClinicManagementSystem.repository.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceTest {

    @InjectMocks
    OwnerServiceImpl ownerService;

    @Mock
    OwnerRepository ownerRepository;

    @Test
    void findOwnerByIdTest()
    {
        Pet petMock = mock(Pet.class);
        petMock.setId(1);
        petMock.setName("test");

        List<Pet> pets = new ArrayList<>();
        pets.add(petMock);

        Owner ownerMock = mock(Owner.class);
        ownerMock.setId(1);
        ownerMock.setName("test");
        ownerMock.setLastname("test");
        ownerMock.setPhoneNumber(123);
        ownerMock.setPets(pets);

        when(ownerRepository.findById(ownerMock.getId())).thenReturn(Optional.of(ownerMock));
        Owner findOwner = ownerService.findOwnerById(ownerMock.getId());

        assertEquals(ownerMock, findOwner);
    }

    @Test
    void findAllOwnerTest()
    {
        Owner ownerMock = mock(Owner.class);
        ownerMock.setId(1);
        ownerMock.setName("test");
        ownerMock.setLastname("test");
        ownerMock.setPhoneNumber(123);

        List<Owner> owners = new ArrayList<>();
        owners.add(ownerMock);

        when(ownerRepository.findAll()).thenReturn(owners);
        List<Owner> ownerList = ownerService.findAllOwner();

        assertEquals(owners, ownerList);
    }

    @Test
    void createOwnerTest()
    {
        Owner ownerMock = mock(Owner.class);
        ownerMock.setId(1);
        ownerMock.setName("test");
        ownerMock.setLastname("test");
        ownerMock.setPhoneNumber(123);

        when(ownerRepository.save(ownerMock)).thenReturn(ownerMock);
        Owner owner = ownerService.createOwner(ownerMock);

        assertEquals(ownerMock, owner);
    }

    @Test
    void updateOwnerTest()
    {
        Owner ownerMock = mock(Owner.class);
        ownerMock.setId(1);
        ownerMock.setName("test");
        ownerMock.setLastname("test");
        ownerMock.setPhoneNumber(123);

        when(ownerRepository.save(ownerMock)).thenReturn(ownerMock);
        Owner owner = ownerService.updateOwner(ownerMock);

        assertEquals(ownerMock, owner);
    }


    @Test
    void findOwnerByNameTest()
    {
        Owner ownerMock = mock(Owner.class);
        ownerMock.setId(1);
        ownerMock.setName("test");
        ownerMock.setLastname("test");
        ownerMock.setPhoneNumber(123);

        Owner anotherOwnerMock = mock(Owner.class);
        anotherOwnerMock.setId(2);
        anotherOwnerMock.setName("test");
        anotherOwnerMock.setLastname("testName");
        anotherOwnerMock.setPhoneNumber(1233);

        Collection<Owner> owners = new ArrayList<>();
        owners.add(ownerMock);
        owners.add(anotherOwnerMock);

        when(ownerRepository.findByName("test")).thenReturn(owners);
        Collection<Owner> ownerCollection = ownerService.findOwnerByName("test");

        assertEquals(owners, ownerCollection);
    }
}