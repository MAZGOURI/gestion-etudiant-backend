package org.gestion.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.gestion.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface IEtudiantDao extends JpaRepository<Etudiant, Integer> {
	List<Etudiant> findByNom(String nom);
	List<Etudiant> findByPrenom(String prenom);
	@Transactional
	void deleteByNom(String nom);
	@Modifying
	@Query("update Etudiant e set e.nom = :nom, e.prenom = :prenom where e.id = :id")
	void setEtudiantById(@Param("nom")String nom, @Param("prenom")String prenom, @Param("id")Integer id);
}
