package com.nienauczecieprogramowaczadarmo.springdemozadarmo.repository;

import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {


}
