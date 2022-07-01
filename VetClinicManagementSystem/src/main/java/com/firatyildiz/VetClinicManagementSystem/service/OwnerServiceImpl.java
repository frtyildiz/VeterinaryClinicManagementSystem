package com.firatyildiz.VetClinicManagementSystem.service;

import com.firatyildiz.VetClinicManagementSystem.entity.Owner;
import com.firatyildiz.VetClinicManagementSystem.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    OwnerRepository ownerRepository;

    public Owner findOwnerById(Long id)
    {
        return ownerRepository.findById(id).get();
    }

    public List<Owner> findAllOwner()
    {
        return ownerRepository.findAll();
    }

    public Owner createOwner(Owner owner)
    {
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(Owner owner)
    {
        return ownerRepository.save(owner);
    }

    public void deleteOwner(Owner owner)
    {
        ownerRepository.delete(owner);
    }

    public Collection<Owner> findOwnerByName(String name)
    {
        return ownerRepository.findByName(name);
    }
}

