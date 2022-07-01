package com.firatyildiz.VetClinicManagementSystem.service;

import com.firatyildiz.VetClinicManagementSystem.entity.Owner;

import java.util.Collection;
import java.util.List;

public interface OwnerService {

    Owner findOwnerById(Long id);

    List<Owner> findAllOwner();

    Owner createOwner(Owner owner);

    Owner updateOwner(Owner owner);

    void deleteOwner(Owner owner);

    Collection<Owner> findOwnerByName(String name);
}
