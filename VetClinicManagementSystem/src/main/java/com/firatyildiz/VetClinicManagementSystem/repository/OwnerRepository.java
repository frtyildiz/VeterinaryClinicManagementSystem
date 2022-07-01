package com.firatyildiz.VetClinicManagementSystem.repository;

import com.firatyildiz.VetClinicManagementSystem.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Query("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets WHERE owner.name LIKE :name")
    Collection<Owner> findByName(String name);

}
