package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Candidates")
public class Candidate {

	// Entity variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	
	@OneToMany
	@JoinColumn(name="id_candidate")
	private List<Candidate_position> candidatePosition;
	
	@OneToMany
	@JoinColumn(name="id_candidate")
	private List<Candidate_skill> candidateSkill;
	
	// Default constructor
	public Candidate() {
		
	}

	/**
	 * Constructor with full params
	 * @param id
	 * @param name
	 * @param surname
	 * @param candidatePosition
	 * @param candidateSkill
	 */
	public Candidate(int id, String name, String surname, List<Candidate_position> candidatePosition,
			List<Candidate_skill> candidateSkill) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.candidatePosition = candidatePosition;
		this.candidateSkill = candidateSkill;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the candidatePosition
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "CandidatePosition")
	public List<Candidate_position> getCandidatePosition() {
		return candidatePosition;
	}

	/**
	 * @param candidatePosition the candidatePosition to set
	 */
	public void setCandidatePosition(List<Candidate_position> candidatePosition) {
		this.candidatePosition = candidatePosition;
	}

	/**
	 * @return the candidateSkill
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "CandidateSkill")
	public List<Candidate_skill> getCandidateSkill() {
		return candidateSkill;
	}

	/**
	 * @param candidateSkill the candidateSkill to set
	 */
	public void setCandidateSkill(List<Candidate_skill> candidateSkill) {
		this.candidateSkill = candidateSkill;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
}
