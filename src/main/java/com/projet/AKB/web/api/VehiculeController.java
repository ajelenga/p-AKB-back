package com.projet.AKB.web.api;



import com.projet.AKB.dtos.vehicule.VehiculeMapper;
import com.projet.AKB.dtos.vehicule.VehiculeTO;
import com.projet.AKB.entities.Vehicule;
import com.projet.AKB.repositories.vehicule.VehiculeRepository;
import com.projet.AKB.service.inscription.InscriptionServiceImpl;
import com.projet.AKB.service.vehicule.VehiculeService;
import com.projet.AKB.service.vehicule.VehiculeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class VehiculeController {
    private static final Logger log = LoggerFactory.getLogger(VehiculeController.class);

    @Autowired
    VehiculeServiceImpl vehiculeService;

    @Autowired
    VehiculeRepository vehiculeRepository;

    @Autowired
    VehiculeMapper vehiculeMapper;

/*    @Autowired
    VehiculeMapper vehiculeMapper;*/
    @GetMapping(path = "/vehicules",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Vehicule>> vehiculeList(){
        log.info("getVehicule start");
        log.info("getVehicule start{} ++++++++++++++++++++");
        List<Vehicule> l= new ArrayList<>();
        vehiculeService.getVehicules().get(0);
        return new ResponseEntity<>(l, HttpStatus.OK);

    }

    @GetMapping(path = "/vehiculeOne/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehiculeTO> getConnexion(@PathVariable(name = "id") Long code) throws Exception {
        Vehicule v =new Vehicule();
        VehiculeTO VTO = new VehiculeTO();
        Vehicule v1 = vehiculeRepository.findById(code).get();
        VTO = vehiculeMapper.toDTO(v1);
      //  v = vehiculeMapper.toEntity(v1);
        return new ResponseEntity<>(VTO, HttpStatus.OK);

    }


    @PostMapping(value = "/ajoutVehicule", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody Vehicule vehicule) throws Exception {
        log.info("ajoutVehicule start");
        vehiculeRepository.save(vehicule);
        return new ResponseEntity<String>("Vehciule ajouter", HttpStatus.CREATED);
    }



}
