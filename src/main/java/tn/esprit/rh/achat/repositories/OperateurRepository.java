package tn.esprit.rh.achat.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.entities.Operateur;

import java.util.Date;
import java.util.List;

@Repository
public interface OperateurRepository extends CrudRepository<Operateur, Long> {

    @Query("SELECT  o FROM Operateur o WHERE o.dateNaissance between :d1 AND :d2")
    List<Operateur> retrieveOperateursByDateNaissance(@Param("d1") Date startDate, @Param("d2") Date endDate);

}
