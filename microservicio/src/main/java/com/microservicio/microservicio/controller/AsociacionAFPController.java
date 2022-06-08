package com.microservicio.microservicio.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.microservicio.microservicio.model.entity.AsociacionAFP;
import com.microservicio.microservicio.repository.AsociacionAFPRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/asociacionafp")
public class AsociacionAFPController {

    @Autowired
    private AsociacionAFPRepository asociacionAFPRepository;

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @GetMapping("/listado")
    @ResponseStatus(HttpStatus.OK)
    public List<AsociacionAFP> getAllAFP(){
        LOGGER.info("Hizo la peticion de listado");
        return asociacionAFPRepository.findAll();
    }

    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public void createAFP(@RequestBody AsociacionAFP asociacionAFP){
        LOGGER.info("Hizo la peticion de nuevo");
        asociacionAFPRepository.save(asociacionAFP);
    }

    @GetMapping("/obtener/{idAsociacionAFP}")
    public ResponseEntity<AsociacionAFP> getAFP(@PathVariable(value = "idAsociacionAFP") String idAsociacionAFP){

        LOGGER.info("Hizo la peticion de obtener por id");
        Optional<AsociacionAFP> asociacionAFP=asociacionAFPRepository.findById(idAsociacionAFP);
        if(asociacionAFP.isPresent()){
            return new ResponseEntity<>(asociacionAFP.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(asociacionAFP.get(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{idAsociacionAFP}")
    public String deleteAFP(@PathVariable(value = "idAsociacionAFP") String idAsociacionAFP){
        LOGGER.info("Hizo la peticion de eliminar por id");
        asociacionAFPRepository.deleteById(idAsociacionAFP);

        return "Se elimino correctamente el producto";
    }

    @PutMapping("/actualizar/{idAsociacionAFP}")
    public AsociacionAFP updateAFP(@RequestBody AsociacionAFP asociacionAFP,@PathVariable(value = "idAsociacionAFP") String idAsociacionAFP){

        LOGGER.info("Hizo la peticion de actualizar");
        asociacionAFP.setIdAsociacionAFP(idAsociacionAFP);
        asociacionAFPRepository.save(asociacionAFP);

        return asociacionAFP;
    }
}
