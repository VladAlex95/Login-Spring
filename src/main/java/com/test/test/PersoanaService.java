package com.test.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersoanaService {
    private  final PersoanaDo persoanaDo;
    @Autowired
    public PersoanaService(@Qualifier ("postgres")PersoanaDo persoanaDo) {
        this.persoanaDo = persoanaDo;
    }
    @PostMapping
   public int AdaugaPersoana(Persoana persoana){
    return persoanaDo.insereazaPersoana(persoana);
   }
   @GetMapping
   public List<Persoana> SelecteazaToatepersoanele(){
        return persoanaDo.SelecteazaToatepersoanele();
   }
    public Optional<Persoana>SelecteazapersoanaprinID(UUID id){
        return persoanaDo.SelecteazapersoanaprinID(id);
    }
    public int  stergerePersoana(UUID id){
        return persoanaDo.StergepersoanaprinID(id);
    }
    public int actualizarePersoana(UUID id,Persoana persoanano ){
     return persoanaDo.ActualizarepersoanaprinID(id,persoanano);
    }
}
