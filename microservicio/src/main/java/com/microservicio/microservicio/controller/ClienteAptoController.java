package com.microservicio.microservicio.controller;

import com.microservicio.microservicio.model.entity.ClienteApto;
import com.microservicio.microservicio.repository.ClienteAptoRepository;
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
@RequestMapping("/api/clienteapto")
public class ClienteAptoController {

    @Autowired
    private ClienteAptoRepository clienteAptoRepository;

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @GetMapping("/listado")
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteApto> getAllClientsAprobed(){
        LOGGER.info("Hizo la peticion de listado");
        return clienteAptoRepository.findAll();
    }

    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public void createClientAprobed(@RequestBody ClienteApto clienteApto){
        LOGGER.info("Hizo la peticion de nuevo");
        clienteAptoRepository.save(clienteApto);
    }

    @GetMapping("/obtener/{idClienteApto}")
    public ResponseEntity<ClienteApto> getClient(@PathVariable(value = "idClienteApto") String idClienteApto){

        LOGGER.info("Hizo la peticion de obtener por id");
        Optional<ClienteApto> clienteApto= clienteAptoRepository.findById(idClienteApto);
        if(clienteApto.isPresent()){
            return new ResponseEntity<>(clienteApto.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(clienteApto.get(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{idClienteApto}")
    public String deleteClientAprobed(@PathVariable(value = "idClienteApto") String idClienteApto){
        LOGGER.info("Hizo la peticion de eliminar por id");
        clienteAptoRepository.deleteById(idClienteApto);

        return "Se elimino correctamente el producto";
    }

    @PutMapping("/actualizar/{idClienteApto}")
    public ClienteApto updateClientAprobed(@RequestBody ClienteApto clienteApto, @PathVariable(value = "idClienteApto") String idClienteApto){

        LOGGER.info("Hizo la peticion de actualizar");
        clienteApto.setIdClienteApto(idClienteApto);
        clienteAptoRepository.save(clienteApto);

        return clienteApto;
    }
}
