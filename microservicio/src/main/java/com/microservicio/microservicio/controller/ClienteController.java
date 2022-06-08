package com.microservicio.microservicio.controller;

import com.microservicio.microservicio.model.entity.Cliente;
import com.microservicio.microservicio.repository.ClienteRepository;
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
@RequestMapping("/api/cliente")

public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @GetMapping("/listado")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> getAllClients(){
        LOGGER.info("Hizo la peticion de listado");
        return clienteRepository.findAll();
    }


    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public void createClient(@RequestBody Cliente cliente){
        LOGGER.info("Hizo la peticion de nuevo");

        clienteRepository.save(cliente);
    }

    @GetMapping("/obtener/{idCliente}")
    public ResponseEntity<Cliente> getClient(@PathVariable(value = "idCliente") String idCliente){

        LOGGER.info("Hizo la peticion de obtener por id");
        Optional<Cliente> cliente=clienteRepository.findById(idCliente);
        if(cliente.isPresent()){
            return new ResponseEntity<>(cliente.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(cliente.get(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{idCliente}")
    public String deleteClient(@PathVariable(value = "idCliente") String idCliente){
        LOGGER.info("Hizo la peticion de eliminar por id");
        clienteRepository.deleteById(idCliente);

        return "Se elimino correctamente el producto";
    }

    @PutMapping("/actualizar/{idCliente}")
    public Cliente updateClient(@RequestBody Cliente cliente,@PathVariable(value = "idCliente") String idCliente){

        LOGGER.info("Hizo la peticion de actualizar");
        cliente.setIdCliente(idCliente);
        clienteRepository.save(cliente);

        return cliente;
    }
}
