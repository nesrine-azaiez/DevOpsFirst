package tn.esprit.rh.achat.controllers;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import tn.esprit.rh.achat.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.services.ICategorieProduitService;

@RestController
@Api(tags = "Gestion des categories Produit")
@RequestMapping("/categorieProduit")

public class CategorieProduitController {

    @Autowired
    ICategorieProduitService categorieProduitService;


    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/retrieve-all-categorieProduit")
    @ResponseBody
    public List<CategorieProduit> getCategorieProduit() {
        return categorieProduitService.retrieveAllCategorieProduits();
    }


    @GetMapping("/retrieve-categorieProduit/{categorieProduit-id}")
    @ResponseBody
    public CategorieProduit retrieveCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
        return categorieProduitService.retrieveCategorieProduit(categorieProduitId);
    }


    @PostMapping("/add-categorieProduit")
    @ResponseBody
    public CategorieProduit addCategorieProduit(@RequestBody CategorieProduitDTO cp) {
        CategorieProduit persistentC = modelMapper.map(cp,  CategorieProduit.class);
        return categorieProduitService.addCategorieProduit(persistentC );
    }


    @DeleteMapping("/remove-categorieProduit/{categorieProduit-id}")
    @ResponseBody
    public void removeCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
        categorieProduitService.deleteCategorieProduit(categorieProduitId);
    }


    @PutMapping("/modify-categorieProduit")
    @ResponseBody
    public CategorieProduit modifyCategorieProduit(@RequestBody CategorieProduitDTO categorieProduit) {
        CategorieProduit persistentC = modelMapper.map(categorieProduit,  CategorieProduit.class);
        return categorieProduitService.updateCategorieProduit(persistentC);
    }


}
