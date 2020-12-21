package com.test.test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersoanaDo {
    int insereazaPersoana(UUID id , Persoana persoana);
    default  int  insereazaPersoana(Persoana persoana){
        UUID  id = UUID.randomUUID();
        return insereazaPersoana(id,persoana);
    }
    List<Persoana> SelecteazaToatepersoanele();

    Optional<Persoana> SelecteazapersoanaprinID(UUID id);
    int StergepersoanaprinID(UUID id);
    int ActualizarepersoanaprinID(UUID id,Persoana persoana);
}
