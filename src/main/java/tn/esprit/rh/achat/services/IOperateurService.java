package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.Operateur;

import java.util.Date;
import java.util.List;


public interface IOperateurService {

    List<Operateur> retrieveAllOperateurs();

    Operateur addOperateur(Operateur o);

    void deleteOperateur(Long id);

    Operateur updateOperateur(Operateur o);

    Operateur retrieveOperateur(Long id);

    List<Operateur> getOperateurByDateNaissance(Date d1, Date d2);

}
