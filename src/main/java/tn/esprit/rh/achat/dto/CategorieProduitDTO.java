package tn.esprit.rh.achat.dto;

public class CategorieProduitDTO {
    private Long idCategorieProduit;
    private String codeCategorie;
    private String libelleCategorie;

    public CategorieProduitDTO(Long idCategorieProduit, String codeCategorie, String libelleCategorie) {
        this.idCategorieProduit = idCategorieProduit;
        this.codeCategorie = codeCategorie;
        this.libelleCategorie = libelleCategorie;
    }
}
