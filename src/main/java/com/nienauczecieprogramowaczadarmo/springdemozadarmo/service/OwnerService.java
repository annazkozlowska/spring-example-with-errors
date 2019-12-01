package com.nienauczecieprogramowaczadarmo.springdemozadarmo.service;

import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Address;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Owner;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Pet;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.repository.OwnerRepository;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.repository.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private static final Logger logger = LoggerFactory.getLogger(OwnerService.class);

    private OwnerRepository ownerRepository;
    private PetRepository petRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository, PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
    }

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> allOwners() {

        List<Owner> result = (List<Owner>) ownerRepository.findAll();
        logger.info("result from db: [{}]", result);
        return result;
    }

    public Owner saveOwner(Owner toSave) {
        logger.info("owner before save: [{}]" + toSave);
        Owner saved = ownerRepository.save(toSave);
        logger.info("owner after save: [{}]" + saved);


        return saved;
    }

    public Owner saveOwnerWithPet(Owner owner, Long petId){
        //znajdz peta
        Optional<Pet> pet = petRepository.findById(petId);
        //daj ownerowi
        owner.setPet(pet.orElse(null));
        return ownerRepository.save(owner);
    }

}
