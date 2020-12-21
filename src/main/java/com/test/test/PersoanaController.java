package com.test.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/persoana")
@RestController
public class PersoanaController {
 private final PersoanaService persoanaService;
@Autowired
    public PersoanaController(PersoanaService persoanaService) {
        this.persoanaService = persoanaService;
    }

  @PostMapping
    public int AdaugaPersoana (Persoana persoana){
     return   persoanaService.AdaugaPersoana(persoana);
    }
    @GetMapping
    List<Persoana> SelecteazaToatepersoanele(){
      return persoanaService.SelecteazaToatepersoanele();
    }
    @GetMapping(path ="{id}")
    public Persoana SelecteazapersoanaprinID(@PathVariable("id") UUID id ){
        return persoanaService.SelecteazapersoanaprinID(id)
                .orElse(null);
    }
    @DeleteMapping(path ={"id"})
    public void StergepersoanaprinID(@PathVariable("id")UUID id){
        persoanaService.stergerePersoana(id);
    }
    public void Actualizeazapersoana(@PathVariable("id")UUID id ,@RequestBody Persoana persoanaactuala){
    persoanaService.actualizarePersoana(id,persoanaactuala);
    }
}
