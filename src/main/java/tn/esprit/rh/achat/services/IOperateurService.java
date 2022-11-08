package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.dto.OperateurDto;

import java.util.List;


public interface IOperateurService {

	List<OperateurDto> retrieveAllOperateurs();

	OperateurDto addOperateur(OperateurDto o);

	void deleteOperateur(Long id);

	OperateurDto updateOperateur(OperateurDto o);

	OperateurDto retrieveOperateur(Long id);

}
