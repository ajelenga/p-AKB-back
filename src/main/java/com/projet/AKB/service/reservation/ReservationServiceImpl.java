package com.projet.AKB.service.reservation;

import com.projet.AKB.dtos.request.RequestReservationTO;
import com.projet.AKB.dtos.reservation.reservationMapImpl;
import com.projet.AKB.dtos.reservation.ReservationTO;
import com.projet.AKB.entities.Compte;
import com.projet.AKB.entities.Reservation;
import com.projet.AKB.entities.Vehicule;
import com.projet.AKB.repositories.inscription.InscriptionRepository;
import com.projet.AKB.repositories.reservation.ReservationRepository;
import com.projet.AKB.repositories.vehicule.VehiculeRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private reservationMapImpl reservationMapper;

    @Autowired
    private InscriptionRepository compteRespository;
    @Autowired
    private VehiculeRepository vehiculeRepository;


    public List<ReservationTO> getReservation() {
        List<ReservationTO> reservationTOList = new ArrayList<>();
        ReservationTO reservationTO = new ReservationTO();
        reservationRepository.findAll().forEach(reservation -> {
            reservationTOList.add(reservationMapper.toDTO(reservation));
        });

        return reservationTOList;
    }


    public String formatDate(String Date) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Date);
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("yyyy-MM-dd");
        return (formater.format(date));

    }

    public String faireReservation(RequestReservationTO data) {
        String res = "NO";

        Optional<Compte> c = compteRespository.findById(Long.parseLong(data.getIdC()));
        Optional<Reservation> r = reservationRepository.findById(Long.parseLong(data.getIdR()));
        Optional<Vehicule> v = vehiculeRepository.findById(Long.parseLong(data.getIdV()));
        Reservation r1= r.get() ;
        if(c !=null && v !=null){
            v.get().setStatutvcl("à louer");
            c.get().getReservation().add(r1);
            res="Reservation effectué";

        }
        Optional<Compte> c1 = compteRespository.findById(Long.parseLong(data.getIdC()));
        Optional<Reservation> r2 = reservationRepository.findById(Long.parseLong(data.getIdR()));
        Optional<Vehicule> v1 = vehiculeRepository.findById(Long.parseLong(data.getIdV()));
        compteRespository.save(c1.get());
        reservationRepository.save(r2.get());
        return res;
    }


}
