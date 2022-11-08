package tn.esprit.rh.achat;




import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.dto.OperateurDto;
import tn.esprit.rh.achat.services.IOperateurService;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ServiceOperateurImplTest {
    @Autowired
    IOperateurService operateurService;
    @Test
    public void testAddOperateur() {
        OperateurDto operateur = OperateurDto
                .builder()
                .idOperateur(1L)
                .nom("khaled")
                .prenom("kedhai")
                .password("test")
                .build();
        OperateurDto savedOperateur = operateurService.addOperateur(operateur);
        log.info(savedOperateur.getIdOperateur().toString());
        assertNotNull(savedOperateur);
        assertEquals(Optional.ofNullable(savedOperateur.getPassword()),Optional.of("test"));
        operateurService.deleteOperateur(savedOperateur);
    }
    @Test
    public void testRetrieveOperateur() {
        OperateurDto operateur = OperateurDto
                .builder()
                .nom("khaled")
                .prenom("kedhai")
                .password("test")
                .build();
        OperateurDto savedOperateur = operateurService.addOperateur(operateur);
        assertEquals(savedOperateur.getIdOperateur(),operateurService.retrieveOperateur(savedOperateur.getIdOperateur()).getIdOperateur());
        operateurService.deleteOperateur(savedOperateur);
    }
    @Test
    public void testDeleteOperateur() {
        OperateurDto operateur = OperateurDto
                .builder()
                .nom("khaled")
                .prenom("kedhai")
                .password("test")
                .build();
        OperateurDto savedOperateur= operateurService.addOperateur(operateur);
        log.info(savedOperateur.getIdOperateur().toString());
        operateurService.deleteOperateur(savedOperateur);
        assertNull(operateurService.retrieveOperateur(savedOperateur.getIdOperateur()));

    }

    @Test
    public void TestUpdateOperateur(){
        OperateurDto operateur = OperateurDto
                .builder()
                .nom("khaled")
                .prenom("kedhai")
                .password("test")
                .build();
        OperateurDto savedOperateur = operateurService.addOperateur(operateur);
        savedOperateur.setPassword("test2");
        OperateurDto updateOperateur = operateurService.updateOperateur(savedOperateur);
        assertEquals(Optional.ofNullable(updateOperateur.getPassword()),Optional.of(savedOperateur.getPassword()));
        operateurService.deleteOperateur(updateOperateur);
    }
    @Test
    public void TestRetrieveAllOperateur() {
        OperateurDto operateur = OperateurDto
                .builder()
                .nom("khaled")
                .prenom("kedhai")
                .password("test")
                .build();
        log.info("add new test operateur");
        OperateurDto savedOperateur = operateurService.addOperateur(operateur);
        log.info("retrieve all operateurs");
        List<OperateurDto> OperateurList = operateurService.retrieveAllOperateurs();
        log.info("assert that operateur list is not empty");
        assertNotEquals(OperateurList.size(), 0);
        log.info("delete the test operateur");
        operateurService.deleteOperateur(savedOperateur);
    }
}
