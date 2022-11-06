package tn.esprit.rh.achat;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.services.IFournisseurService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static tn.esprit.rh.achat.entities.CategorieFournisseur.ORDINAIRE;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurServiceITest {

    @Autowired
    IFournisseurService fournisseurService;

    @Test
    @Order(3)
    public void testretrieveAllFournisseurs() {
        List<Fournisseur> listFournisseurs = fournisseurService.retrieveAllFournisseurs();
        Assertions.assertEquals(0, listFournisseurs.size());
    }
    @Test
    @Order(1)
    public void testaddFournisseur() {
        List<Fournisseur> Fournisseurs = fournisseurService.retrieveAllFournisseurs();
        int expected=Fournisseurs.size();
        Fournisseur f = new Fournisseur("f1aa", "2", CategorieFournisseur.CONVENTIONNE);
        Fournisseur savedFournisseur= fournisseurService.addFournisseur(f);

        assertEquals(expected+1, fournisseurService.retrieveAllFournisseurs().size());
        assertNotNull(savedFournisseur.getLibelle());
        fournisseurService.deleteFournisseur(savedFournisseur.getIdFournisseur());

    }


    @Test
    @Order(2)
    public void testdeleteFournisseur() {
        Fournisseur f = new Fournisseur("f1aa", "2", CategorieFournisseur.CONVENTIONNE);
        Fournisseur savedFournisseur= fournisseurService.addFournisseur(f);
        fournisseurService.deleteFournisseur(savedFournisseur.getIdFournisseur());
        assertNull(fournisseurService.retrieveFournisseur(savedFournisseur.getIdFournisseur()));
    }





}
