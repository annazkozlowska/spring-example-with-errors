package com.nienauczecieprogramowaczadarmo.springdemozadarmo.repository;

import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> { //wybieramy Long bo taka wartosc ma id

}
// nie musimy w tym interfejsie implementowac metod ktore
// ma CrudRepository - spring robi to za nas


//jak wyrzuci nas z bazy danych to wchodzimy do pliku h2 / bin i wybieramy plik z batem
// i znowu sie logujemy