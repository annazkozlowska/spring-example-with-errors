package com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain;

import javax.persistence.*;

@Entity
public class Owner {

    //klucz glowny
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nick;
    @OneToOne
    private Pet pet;

    //konstruktor bez parametrow

     public Owner(){
     }

    public Owner(String nick, Pet pet) {
        this.nick = nick;
        this.pet = pet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", pet=" + pet +
                '}';
    }
}
