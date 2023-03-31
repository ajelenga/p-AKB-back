package com.projet.AKB.web.api;

import com.projet.AKB.dtos.StatutConnexion;
import com.projet.AKB.dtos.request.RequestRUserTO;
import com.projet.AKB.dtos.request.RequestReservationTO;
import com.projet.AKB.dtos.request.RequestTO;
import com.projet.AKB.dtos.reservation.ReservationMapper;
import com.projet.AKB.dtos.reservation.ReservationTO;
import com.projet.AKB.dtos.vehicule.VehiculeMapper;
import com.projet.AKB.dtos.vehicule.VehiculeMapperImpl;
import com.projet.AKB.dtos.vehicule.VehiculeTO;
import com.projet.AKB.entities.Reservation;
import com.projet.AKB.entities.Vehicule;
import com.projet.AKB.entities.Verificateur;
import com.projet.AKB.repositories.reservation.ReservationRepository;
import com.projet.AKB.repositories.vehicule.VehiculeRepository;
import com.projet.AKB.service.reservation.ReservationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin
public class ReservationController {
    private static final Logger log = LoggerFactory.getLogger(ReservationController.class);
    @Autowired
    VehiculeRepository vehiculeRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationServiceImpl reservationService;
@Autowired
VehiculeMapperImpl vehiculeMapper;

    @Autowired
    ReservationMapper reservationMapper;
    @GetMapping(path = "/allReservation",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReservationTO>> vehiculeList(){
        log.info("getReservation start");
        log.info("getReservation start{} ++++++++++++++++++++");
        List<ReservationTO> l= new ArrayList<>();

        l = reservationService.getReservation();
        return new ResponseEntity<>(l, HttpStatus.OK);

    }



    @GetMapping(path = "/RequestReservation",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reservation>> RequestReservation(@RequestBody RequestTO requestTO) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(requestTO.getDateDebut());

        System.out.println(date);
        // ajouter une date
        reservationService.formatDate(requestTO.getDateDebut());
        List<Reservation> l;
        l =  reservationRepository.findReservation(reservationService.formatDate(requestTO.getDateDebut()),requestTO.getAddressePrise());
        /*l =  reservationRepository.findReservation(reservationService.formatDate(requestTO.getDateDebut()),reservationService.formatDate(requestTO.getDateFin()),requestTO.getAddressePrise()); */


        return new ResponseEntity<>(l, HttpStatus.OK);
    }


    @PostMapping(path = "/RequestReservation",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReservationTO>> RequestReservationPost(@RequestBody RequestTO requestTO) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(requestTO.getDateDebut());
        log.info("RequestReservation avec conditions {} ++++++++++++++++++++", requestTO );
        System.out.println(date);
        // ajouter une date
        reservationService.formatDate(requestTO.getDateDebut());
        List<Reservation> l;
        ReservationTO RTO = new ReservationTO();
        Reservation r1;
        List<ReservationTO> lVTO = new ArrayList<ReservationTO>();
        l =  reservationRepository.findReservation(reservationService.formatDate(requestTO.getDateDebut()),requestTO.getAddressePrise());
       // l =  reservationRepository.findReservation(reservationService.formatDate(requestTO.getDateDebut()),reservationService.formatDate(requestTO.getDateFin()),requestTO.getAddressePrise());
        log.info("RequestReservation avec conditions liste renvoyé {} ++++++++++++++++++++", l );
        for(Reservation r : l){

            r1= r;
            RTO = reservationMapper.toDTO(r1);
            VehiculeTO VTO = new VehiculeTO();
            Vehicule v1 = vehiculeRepository.findById(r.getVehicule().getIdvcl()).get();
            VTO = vehiculeMapper.toDTO(v1);
            RTO.setVehiculeTO(VTO);
            if(!lVTO.contains(RTO)) {
                lVTO.add(RTO);
            }
        }

        return new ResponseEntity<>(lVTO, HttpStatus.OK);
    }





    @PutMapping(path = "/AjoutReservation",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> AddReservation(@RequestBody Reservation reservation) throws ParseException {
        Vehicule v = vehiculeRepository.save(reservation.getVehicule());
        Reservation r = reservationRepository.save(reservation);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    @GetMapping(path = "/reservationOne/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReservationTO> getreservationOne(@PathVariable(name = "id") Long code) throws Exception {
        log.info("getReservation details start{} ++++++++++++++++++++");
        Reservation v =new Reservation();
        ReservationTO RTO = new ReservationTO();
        Reservation r1;
        List<Reservation> l = reservationRepository.findAll();
        for(Reservation r : l ){
            if(r.getIdrsv().equals(code)){
                r1= r;
                RTO = reservationMapper.toDTO(r1);
                VehiculeTO VTO = new VehiculeTO();
                Vehicule v1 = vehiculeRepository.findById(r.getVehicule().getIdvcl()).get();
                VTO = vehiculeMapper.toDTO(v1);
                RTO.setVehiculeTO(VTO);
            }
        }
        return new ResponseEntity<>(RTO, HttpStatus.OK);
    }


    @PostMapping(value = "/effectuerReservation", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> faireReservation(@RequestBody RequestReservationTO data)  throws Exception {
        System.out.println(data.getIdV() + data.getIdC());
        String res  = reservationService.faireReservation(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    @PostMapping(path = "/ReservationUser",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReservationTO>> RequestReservationPost(@RequestBody RequestRUserTO requestTO) throws ParseException {
        log.info(requestTO.getEmail());
        List<ReservationTO> reservationTOList = reservationService.reservationUser(requestTO);
        log.info(requestTO.getEmail());
        return new ResponseEntity<>(reservationTOList, HttpStatus.OK);
    }








}
