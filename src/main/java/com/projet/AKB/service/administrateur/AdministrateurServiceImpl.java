package com.projet.AKB.service.administrateur;


import com.projet.AKB.entities.Administrateur;
import com.projet.AKB.entities.Compte;
import com.projet.AKB.repositories.administrateur.AdminRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service
@Component
public class AdministrateurServiceImpl implements AdministrateurService{
    @Autowired
    AdminRepository adminRepository;
    @Override
    public Administrateur findBymailcpt(String email) {
        return adminRepository.findBymailadm(email);
    }

    @Override
    public Administrateur findBymailcptAndMotdepassecpt(String email, String password) {
        return null;
    }
}
