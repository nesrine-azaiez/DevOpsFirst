package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.dto.OperateurDto;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;

import java.util.List;

@Service
@Slf4j
public class OperateurServiceImpl implements IOperateurService {

	@Autowired
	OperateurRepository operateurRepository;
	@Override
	public List<OperateurDto> retrieveAllOperateurs() {
		long start = System.currentTimeMillis();
		log.info("In method retrieveAllOperateurs of OperateurService");
		List<OperateurDto> list = OperateurDto.toDtoList ((List<Operateur>) operateurRepository.findAll());
		log.info("out of method retrieveAllOperateurs of OperateurService");
		long elapsedTime = System.currentTimeMillis() - start;
		log.info("Method execution time: " + elapsedTime + " milliseconds.");
		return list;
	}


	@Override
	public OperateurDto addOperateur(OperateurDto o) {
		long start = System.currentTimeMillis();
		log.info("In method addOperateur of OperateurService");
		Operateur savedOperateur=operateurRepository.save(OperateurDto.toOperateur(o));
		log.info("out of method addOperateur of OperateurService");
		long elapsedTime = System.currentTimeMillis() - start;
		log.info("Method execution time: " + elapsedTime + " milliseconds.");
		return  OperateurDto.toDto(savedOperateur);
	}

	@Override
	public void deleteOperateur(OperateurDto operateurDto) {
		long start = System.currentTimeMillis();
		log.info("In method deleteOperateur of OperateurService");
		operateurRepository.delete(OperateurDto.toOperateur(operateurDto));
		log.info("out of method deleteOperateur of OperateurService");
		long elapsedTime = System.currentTimeMillis() - start;
		log.info("Method execution time: " + elapsedTime + " milliseconds.");

	}

	@Override
	public OperateurDto updateOperateur(OperateurDto o) {
		long start = System.currentTimeMillis();
		log.info("In method updateOperateur of OperateurService");
		operateurRepository.save(OperateurDto.toOperateur(o));
		log.info("out of method updateOperateur of OperateurService");
		long elapsedTime = System.currentTimeMillis() - start;
		log.info("Method execution time: " + elapsedTime + " milliseconds.");
		return o;
	}

	@Override
	public OperateurDto retrieveOperateur(Long id) {
		long start = System.currentTimeMillis();
		log.info("In method retrieveOperateur of OperateurService");
		Operateur operateur = operateurRepository.findById(id).orElse(null);
		log.info("out of method retrieveOperateur of OperateurService");
		long elapsedTime = System.currentTimeMillis() - start;
		log.info("Method execution time: " + elapsedTime + " milliseconds.");
		return OperateurDto.toDto(operateur);
	}

}
