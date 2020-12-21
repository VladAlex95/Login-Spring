package com.test.test;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Persoana {
 private  UUID id;
 private  String nume;
 private   String parola;
 private  String email;
 private  String numartelefon;


    public Persoana(@JsonProperty("id") UUID id,
                    @JsonProperty("nume") String nume,
                    @JsonProperty("parola")String parola,
                    @JsonProperty("email")String email,
                    @JsonProperty("numartelefon")String numartelefon) {
        this.id = id;
        this.nume = nume;
        this.parola = parola;
        this.email = email;
        this.numartelefon = numartelefon;
    }

    public UUID getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getParola() {
        return parola;
    }

    public String getEmail() {
        return email;
    }

    public String getNumartelefon() {
        return numartelefon;
    }
}
