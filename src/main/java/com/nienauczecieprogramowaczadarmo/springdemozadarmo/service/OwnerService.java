package com.nienauczecieprogramowaczadarmo.springdemozadarmo.service;

import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Address;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Owner;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private static final Logger logger = LoggerFactory.getLogger(OwnerService.class);

    private OwnerRepository ownerRepository;

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


}
