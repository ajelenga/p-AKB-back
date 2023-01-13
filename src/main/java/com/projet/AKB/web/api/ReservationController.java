package com.projet.AKB.web.api;

import com.projet.AKB.dtos.request.RequestTO;
import com.projet.AKB.dtos.reservation.ReservationTO;
import com.projet.AKB.entities.Reservation;
import com.projet.AKB.entities.Vehicule;
import com.projet.AKB.repositories.reservation.ReservationRepository;
import com.projet.AKB.repositories.vehicule.VehiculeRepository;
import com.projet.AKB.service.reservation.ReservationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        l =  reservationRepository.findReservation(reservationService.formatDate(requestTO.getDateDebut()),reservationService.formatDate(requestTO.getDateFin()),requestTO.getAddressePrise());


        return new ResponseEntity<>(l, HttpStatus.OK);
    }


    @PutMapping(path = "/AjoutReservation",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> AddReservation(@RequestBody Reservation reservation) throws ParseException {
        Vehicule v = vehiculeRepository.save(reservation.getVehicule());
        Reservation r = reservationRepository.save(reservation);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }



}
