package com.microservicio.microservicio.controller;

import com.microservicio.microservicio.model.entity.SolicitudRetiro;
import com.microservicio.microservicio.repository.SolicitudRetiroRepository;
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
@RequestMapping("/api/solicitudretiro")
public class SolicitudRetiroController {

    @Autowired
    private SolicitudRetiroRepository solicitudRetiroRepository;

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @GetMapping("/listado")
    @ResponseStatus(HttpStatus.OK)
    public List<SolicitudRetiro> getRequest(){
        LOGGER.info("Hizo la peticion de listado");
        return solicitudRetiroRepository.findAll();
    }

    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public void createRequest(@RequestBody SolicitudRetiro solicitudRetiro){
        LOGGER.info("Hizo la peticion de nuevo");
/*        if(solicitudRetiro.getMontoRetiro()<=solicitudRetiro.getClienteApto().getMontoDIsponible())
        {

 */
            solicitudRetiroRepository.save(solicitudRetiro);


/*        }
        else{
            System.out.println("No se puede registrar la solicitud. Monto mayor que el permitido");
        }
*/
    }

    @GetMapping("/obtener/{idClienteApto}")
    public ResponseEntity<SolicitudRetiro> getClient(@PathVariable(value = "idSolicitudRetiro") String idSolicitudRetiro){

        LOGGER.info("Hizo la peticion de obtener por id");
        Optional<SolicitudRetiro> solicitudRetiro= solicitudRetiroRepository.findById(idSolicitudRetiro);
        if(solicitudRetiro.isPresent()){
            return new ResponseEntity<>(solicitudRetiro.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(solicitudRetiro.get(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{idClienteApto}")
    public String deleteRequest(@PathVariable(value = "idSolicitudRetiro") String idSolicitudRetiro){
        LOGGER.info("Hizo la peticion de eliminar por id");
        solicitudRetiroRepository.deleteById(idSolicitudRetiro);

        return "Se elimino correctamente el producto";
    }

    @PutMapping("/actualizar/{idClienteApto}")
    public SolicitudRetiro updateRequest(@RequestBody SolicitudRetiro solicitudRetiro, @PathVariable(value = "idSolicitudRetiro") String idSolicitudRetiro){

        LOGGER.info("Hizo la peticion de actualizar");
        solicitudRetiro.setIdSolicitudRetiro(idSolicitudRetiro);
        solicitudRetiroRepository.save(solicitudRetiro);

        return solicitudRetiro;
    }
}
