package com.nienauczecieprogramowaczadarmo.springdemozadarmo.service;

import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Person;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
    private static final int MAX_SIZE_OF_PERSON_QUERY = 20;

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAllPersons(){

        List<Person> result = new ArrayList<>();

        //1 rozwiazanie
//        int counter = 0;
//        for (Person p : personRepository.findAll()){
//            if (counter < MAX_SIZE_OF_PERSON_QUERY ){
//                counter++;
//                result.add(p);
//            }else{
//                break;
//            }
//        }

        //2 rozwiazanie

        Iterator<Person> personIterator = personRepository.findAll().iterator();
        while (personIterator.hasNext() && result.size() < MAX_SIZE_OF_PERSON_QUERY){ // hasNext pojawia sie przed wartoscia,
            // sprawdza czy jest jakas wartosc to ja zwrac
            Person p = personIterator.next(); //next przesuwa  dalej, sprawdza czy cos jest za - jezeli tak,
            // to zwraca te wartosc i sie przesuwa itd
            result.add(p);

        }
        return result;
    }
}
//findAll zwraca Iterable interfejs
