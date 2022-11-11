package tn.esprit.rh.achat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;

@Service
public class SecteurActiviteServiceImpl implements tn.esprit.rh.achat.services.ISecteurActiviteService {

    @Autowired
    SecteurActiviteRepository secteurActiviteRepository;
    @Override
    public List<SecteurActivite> retrieveAllSecteurActivite() {
        return (List<SecteurActivite>) secteurActiviteRepository.findAll();
    }

    @Override
    public SecteurActivite addSecteurActivite(SecteurActivite saa) {
        secteurActiviteRepository.save(saa);
        return saa;
    }

    @Override
    public void deleteSecteurActivite(Long id) {
        secteurActiviteRepository.deleteById(id);

    }

    @Override
    public SecteurActivite updateSecteurActivite(SecteurActivite sa) {
        secteurActiviteRepository.save(sa);
        return sa;
    }

    @Override
    public SecteurActivite retrieveSecteurActivite(Long id) {
        return  secteurActiviteRepository.findById(id).orElse(null);
    }

}