package com.nienauczecieprogramowaczadarmo.springdemozadarmo.repository;


import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Address;
import org.springframework.data.repository.CrudRepository;

// krok 4 - rozszerz interface CrudRepository
// krok 5 - pierwszy argument generyka - klasa do ktorej tworzymy repozytorium
// krok 6 -podaj typ klucza głównego
// krok 7 - skorzystanie z danych przez serwis
public interface AddressRepository extends CrudRepository<Address, Long> {

}
