package org.gestion.controller;

import java.util.List;
import java.util.Optional;

import org.gestion.dao.IEtudiantDao;
import org.gestion.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*",allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*")
@RestController
@RequestMapping("/api/")
public class EtudiantResource {
	
	@Autowired
	IEtudiantDao etud;
	
	@GetMapping(value="etudiants",produces = {"application/json"})
	@ResponseBody
	public List<Etudiant> getAllEtudiant(){
		return etud.findAll();
	}
	
	@GetMapping(value="noms/{prenom}",produces = {"application/json"})
	public List<Etudiant> getEtudiantByPrenom(@PathVariable("prenom") String prenom){
		return etud.findByPrenom(prenom);
	}
	
	@GetMapping(value="etudiants/{id}",produces = {"application/json"})
	public Optional<Etudiant> getEtudiantById(@PathVariable("id") int id){
		return etud.findById(id);
	}
	
	@GetMapping(value="prenoms/{nom}",produces = {"application/json"})
	public List<Etudiant> getPrenomByNom(@PathVariable("nom") String nom){
		return etud.findByNom(nom);
	}
	
	@PostMapping(value="etudiants",consumes= {"application/json"})
	public Etudiant addEtudiant(@RequestBody Etudiant etudiant){
		return etud.save(etudiant);
	}
	
	@DeleteMapping("etudiants/{nom}")
	public void deleteEtudiant(@PathVariable String nom){
		etud.deleteByNom(nom);
	}
	 
	@PutMapping(value="etudiants",consumes= {"application/json"})
	public Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
		return etud.save(etudiant);
	}
	
	@PutMapping(value="etudiants/{id}",consumes= {"application/json"})
	public Etudiant updateEtudiantById(@PathVariable int id,@RequestBody Etudiant etudiant){
		Etudiant etudiantUpdated = etud.getOne(id);
		etudiantUpdated.setNom(etudiant.getNom());
		etudiantUpdated.setPrenom(etudiant.getPrenom());
		return etud.save(etudiantUpdated);
	}

}
