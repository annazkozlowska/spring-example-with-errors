package com.nienauczecieprogramowaczadarmo.springdemozadarmo.service;

import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Pet;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.repository.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetService {

    public static final Logger logger = LoggerFactory.getLogger(PetService.class);

    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    public Optional<Pet> findById(Long id){
        logger.info("trying to find Pet by id: [{}]", id);

        Optional<Pet> result = petRepository.findById(id);
        logger.info("Pet from repo: [{}]", result);
        return result;
    }
}

