package com.nienauczecieprogramowaczadarmo.springdemozadarmo.repository;

import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

// nie musimy w tym interfejsie implementowac metod ktore
// ma CrudRepository - spring robi to za nas

