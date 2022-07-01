package com.firatyildiz.VetClinicManagementSystem.controller;

import com.firatyildiz.VetClinicManagementSystem.entity.Pet;
import com.firatyildiz.VetClinicManagementSystem.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;

    @GetMapping
    public String displayPets (Model model)
    {
        List<Pet> pets = petService.findAllPets();
        model.addAttribute("pets", pets);

        return "list-pets.html";
    }

    @GetMapping("/new")
    public String displayPetForm (Model model)
    {
        Pet pet = new Pet();
        model.addAttribute("pet", pet);

        return "new-pet.html";
    }

    @PostMapping("/savePet")
    public String createPet (Model model, Pet pet)
    {
        petService.createPet(pet);

        return "redirect:/pet";
    }

    @GetMapping("/update")
    public String displayPetUpdateForm(@RequestParam("id") long id, Model model)
    {
        Pet pet = petService.findPetById(id);
        model.addAttribute("pet", pet);

        return "new-pet.html";
    }

    @GetMapping("/delete")
    public String deletePet(@RequestParam("id") long id, Model model)
    {
        Pet pet = petService.findPetById(id);
        petService.deletePet(pet);

        return "redirect:/pet";
    }
}

