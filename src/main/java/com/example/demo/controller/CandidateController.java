package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CandidateServiceImpl;

import com.example.demo.dto.Candidate;

@RestController
@RequestMapping("/api")
public class CandidateController {
	
	/**
	 * Variables autowired
	 */
	@Autowired
	CandidateServiceImpl candidateServiceImpl;
	
	/**
	 * GET /candidates
	 * @return
	 */
	@GetMapping("/candidates")
	public List<Candidate> listarCandidates(){
		return candidateServiceImpl.listarCandidates();
	}
	
	/**
	 * GET /candidates/name/{name}
	 * @param name
	 * @return
	 */
	@GetMapping("/candidates/name/{name}")
	public List<Candidate> listCandidatesByName(@PathVariable(name="name") String name){
		return candidateServiceImpl.findByName(name);
	}
	
	/**
	 * GET /candidates/username/{username}
	 * @param username
	 * @return
	 */
	@GetMapping("/candidates/username/{username}")
	public Candidate listCandidatesByUsermame(@PathVariable(name="username") String username){
		return candidateServiceImpl.findByUsername(username);
	}
	
	/**
	 * POST /candidates
	 * @param candidate
	 * @return
	 */
	@PostMapping("/candidates")
	public Candidate guardarCandidate(@RequestBody Candidate candidate) {
		return candidateServiceImpl.guardarCandidate(candidate);
	}
	
	/**
	 * GET /candidates/{id}
	 * @param id
	 * @return
	 */
	@GetMapping("/candidates/{id}")
	public Candidate candidateXID(@PathVariable(name="id") int id) {
		
		Candidate candidate_xid= new Candidate();
		candidate_xid=candidateServiceImpl.candidatesXID(id);
		System.out.println("Candidate XID: "+candidate_xid);
		return candidate_xid;
	}

	/**
	 * PUT /candidates/{id}
	 * @param id
	 * @param candidate
	 * @return
	 */
	@PutMapping("/candidates/{id}")
	public Candidate actualizarCandidates(@PathVariable(name="id")int id,@RequestBody Candidate candidate) {
		
		Candidate candidate_seleccionado= new Candidate();
		Candidate candidate_actualizado= new Candidate();
		
		candidate_seleccionado= candidateServiceImpl.candidatesXID(id);
		candidate_seleccionado.setName(candidate.getName());
		candidate_seleccionado.setSurname(candidate.getSurname());
		candidate_seleccionado.setPassword(candidate.getPassword());
		candidate_seleccionado.setUsername(candidate.getUsername());
		candidate_seleccionado.setCandidatePosition(candidate.getCandidatePosition());
		candidate_seleccionado.setCandidateSkill(candidate.getCandidateSkill());
		candidate_seleccionado.setPosition(candidate.getPosition());
		candidate_actualizado = candidateServiceImpl.actualizarCandidates(candidate_seleccionado);
		
		System.out.println("The updated Candidate its: "+ candidate_actualizado);
		
		return candidate_actualizado;
	}
	
	/**
	 * DELETE /candidates/{id}
	 * @param id
	 */
	@DeleteMapping("/candidates/{id}")
	public void eliminarCandidates(@PathVariable(name="id")int id) {
		candidateServiceImpl.eliminarCandidates(id);
	}
}
