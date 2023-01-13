package com.projet.AKB.service.reservation;

import com.projet.AKB.dtos.reservation.reservationMapImpl;
import com.projet.AKB.dtos.reservation.ReservationTO;
import com.projet.AKB.repositories.reservation.ReservationRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

@Autowired
    private reservationMapImpl reservationMapper;



    public List<ReservationTO> getReservation(){
        List<ReservationTO> reservationTOList = new ArrayList<>();
        ReservationTO reservationTO = new ReservationTO();
        reservationRepository.findAll().forEach(reservation -> {
            reservationTOList.add(reservationMapper.toDTO(reservation));
        });

        return reservationTOList;
    }

}
