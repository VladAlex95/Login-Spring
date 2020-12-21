package com.test.test;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FDataAccesService implements PersoanaDo{
    private static List<Persoana> DB = new ArrayList<>();
    @Override
    public int insereazaPersoana(UUID id, Persoana persoana) {
        DB.add(new Persoana(id,persoana.getNume(),persoana.getParola(),persoana.getEmail(),persoana.getNumartelefon()));
        return 1;
    }

    @Override
    public List<Persoana> SelecteazaToatepersoanele() {
        return DB;
    }

    @Override
    public Optional<Persoana> SelecteazapersoanaprinID(UUID id) {
        return DB.stream()
                .filter(persoana ->persoana.getId().equals(id))
                .findFirst();
    }

    @Override
    public int StergepersoanaprinID(UUID id) {
        Optional<Persoana> persoanaM =  SelecteazapersoanaprinID(id);
        if (persoanaM.isEmpty()){
            return 0;
        }
        DB.remove(persoanaM.get());
        return 1;
    }

    @Override
    public int ActualizarepersoanaprinID(UUID id, Persoana update) {
        return SelecteazapersoanaprinID(id)
                .map(persoana -> {
                    int indexOfPersonToUpdate=DB.indexOf(persoana);
                    if (indexOfPersonToUpdate>=0){
                        DB.set(indexOfPersonToUpdate,new Persoana(id,update.getNume(),update.getParola(),update.getEmail(),update.getNumartelefon()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }


}
