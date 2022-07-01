package com.firatyildiz.VetClinicManagementSystem.controller;


import com.firatyildiz.VetClinicManagementSystem.entity.Owner;
import com.firatyildiz.VetClinicManagementSystem.entity.Pet;
import com.firatyildiz.VetClinicManagementSystem.service.OwnerService;
import com.firatyildiz.VetClinicManagementSystem.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @Autowired
    PetService petService;

    @GetMapping
    public String displayOwners(Model model)
    {
        Iterable<Owner> owners = ownerService.findAllOwner();
        model.addAttribute("owners", owners);

        return "list-owners.html";
    }

    @GetMapping("/new")
    public String displayOwnerForm (Model model)
    {
        Owner owner = new Owner();
        List<Pet> pets = petService.findAllPets();

        model.addAttribute("owner", owner);
        model.addAttribute("allPets", pets);

        return "new-owner.html";
    }

    @PostMapping("/saveOwner")
    public String createOwner (Model model, Owner owner, @RequestParam List<Long> pets)
    {
        ownerService.createOwner(owner);

        return "redirect:/owner";
    }

    @GetMapping("/update")
    public String displayOwnerUpdateForm(@RequestParam("id") long id, Model model)
    {
        Owner owner = ownerService.findOwnerById(id);
        List<Pet> pets = petService.findAllPets();

        model.addAttribute("owner", owner);
        model.addAttribute("allPets", pets);

        return "new-owner.html";
    }

    @GetMapping("/delete")
    public String deleteOwner(@RequestParam("id") long id, Model model)
    {
        Owner owner = ownerService.findOwnerById(id);
        ownerService.deleteOwner(owner);

        return "redirect:/owner";
    }

    @GetMapping("/find")
    public String FindForm(Model model)
    {
        model.addAttribute("owner", new Owner());
        return "findOwners";
    }

    @GetMapping("/owners")
    public String OwnerFindForm(Owner owner, BindingResult result, Model model)
    {

        if (owner.getName() == null)
        {
            owner.setName("");
        }

        Collection<Owner> results = ownerService.findOwnerByName(owner.getName());

        if (results.size() < 1)
        {
            result.rejectValue("name", "notFound", "Not Found");
            return "findOwners";
        }

        if (results.size() > 1)
        {

            model.addAttribute("selections", results);
            return "ownersList";
        }

        else
        {
            owner = results.iterator().next();
            return "redirect:/owner/" + owner.getId();
        }
    }

    @RequestMapping("/{id}")
    public ModelAndView findOwner(@PathVariable("id") long id)
    {
        ModelAndView model = new ModelAndView("ownerDetails");
        model.addObject(ownerService.findOwnerById(id));
        return model;
    }
}
