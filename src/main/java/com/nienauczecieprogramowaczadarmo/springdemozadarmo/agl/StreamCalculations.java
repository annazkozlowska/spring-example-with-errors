package com.nienauczecieprogramowaczadarmo.springdemozadarmo.agl;

import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Owner;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Secret;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamCalculations {

    public static void main(String[] args) {


        //MIN
        Stream<BigDecimal> stream1 = Stream.of(BigDecimal.valueOf(5000), BigDecimal.valueOf(6000), BigDecimal.valueOf(7000));

        //1
//        stream1.min((o1, o2) -> o1.compareTo(o2))
//
        //2
//        stream1.min(BigDecimal::compareTo)

        //3
        stream1.min(Comparator.comparing(e1 -> e1))
         .ifPresent(bigDecimal -> System.out.println("min: " + bigDecimal)); // strumienia nie mozna reuzyc
        // musimy zrobic nowy strumien, i nie robic tego na tym samym


        //MAX
        Stream<BigDecimal> stream2 = Stream.of(BigDecimal.valueOf(5000), BigDecimal.valueOf(6000), BigDecimal.valueOf(7000));
        stream2.max(Comparator.comparing(e1 -> e1))
                .ifPresent(bigDecimal -> System.out.println("max: " + bigDecimal));


        //SREDNIA

      BigDecimal sum = Stream.of(BigDecimal.valueOf(5000), BigDecimal.valueOf(6000), BigDecimal.valueOf(7000))
       .reduce(BigDecimal.ZERO, (acumulator, bigDecimal) -> acumulator.add(bigDecimal));
      long number = Stream.of(BigDecimal.valueOf(5000), BigDecimal.valueOf(6000), BigDecimal.valueOf(7000))
              .count();
      //hmmmmm



        Stream<Owner> owners = Stream.of(new Owner("Ania", null), new Owner("Adam", null));
//        owners.max((o1, o2) -> o1.getNick().compareTo(o2.getNick()))
        owners.max(Comparator.comparing(Owner::getNick))
                .ifPresent(Owner -> System.out.println("owner:  " + Owner));



        //strumien intow z klasy secret

        Stream.of(new Secret(5), new Secret(3), new Secret(10))
//              .min(Comparator.comparing(secret -> secret.getNumber()))
                .min(Comparator.comparing(Secret::getNumber))
                .ifPresent(e -> System.out.println("secret: " + e));



    }

    static class Acumulator{
        int numberOfElements;
        int sum;
    }
}

//interfejs funkcyjny, potrzebny by stworzyc lambde. Ma jedna abstrakcyjna. W tym przypadku jesy to interfejs comparable
