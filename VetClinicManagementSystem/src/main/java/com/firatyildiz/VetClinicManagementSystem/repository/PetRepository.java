package com.firatyildiz.VetClinicManagementSystem.repository;

import com.firatyildiz.VetClinicManagementSystem.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
