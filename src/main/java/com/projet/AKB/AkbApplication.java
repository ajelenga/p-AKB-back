package com.projet.AKB;

import com.projet.AKB.entities.Compte;
import com.projet.AKB.repositories.utilisateur.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AkbApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkbApplication.class, args);
	}


	@Bean
	CommandLineRunner start(UtilisateurRepository utilisateurRepository, RepositoryRestConfiguration restConfiguration){

		return args -> {

			restConfiguration.exposeIdsFor(Compte.class);
/*			depenseRepository.save(new Depense(null,"kebab",15.89,new Date(),"nouriture",null,null));
			depenseRepository.save(new Depense(null,"parfum",29.89,new Date(),"habillement",null,null));
			depenseRepository.save(new Depense(null,"salle",25.89,new Date(),"sport",null,null));
			depenseRepository.findAll().forEach(dps->{
				System.out.println(dps.getNom_dpns());
				System.out.println(dps.getValeur_dpns());
				System.out.println(dps.getCategorie_dpns());
				System.out.println(dps.getDate_dpns());
			});*/
		};
	}

}
