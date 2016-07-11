package com.demo.authorizer.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the phases database table.
 * 
 */
@Entity
@Table(name="phases")
@NamedQuery(name="Phas.findAll", query="SELECT p FROM Phas p")
public class Phas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="phase_id")
	private int phaseId;

	@Column(name="phase_name")
	private String phaseName;

	//bi-directional many-to-one association to PhaseSubPhaseMapper
	@OneToMany(mappedBy="phas")
	private List<PhaseSubPhaseMapper> phaseSubPhaseMappers;

	public Phas() {
	}

	public int getPhaseId() {
		return this.phaseId;
	}

	public void setPhaseId(int phaseId) {
		this.phaseId = phaseId;
	}

	public String getPhaseName() {
		return this.phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	public List<PhaseSubPhaseMapper> getPhaseSubPhaseMappers() {
		return this.phaseSubPhaseMappers;
	}

	public void setPhaseSubPhaseMappers(List<PhaseSubPhaseMapper> phaseSubPhaseMappers) {
		this.phaseSubPhaseMappers = phaseSubPhaseMappers;
	}

	public PhaseSubPhaseMapper addPhaseSubPhaseMapper(PhaseSubPhaseMapper phaseSubPhaseMapper) {
		getPhaseSubPhaseMappers().add(phaseSubPhaseMapper);
		phaseSubPhaseMapper.setPhas(this);

		return phaseSubPhaseMapper;
	}

	public PhaseSubPhaseMapper removePhaseSubPhaseMapper(PhaseSubPhaseMapper phaseSubPhaseMapper) {
		getPhaseSubPhaseMappers().remove(phaseSubPhaseMapper);
		phaseSubPhaseMapper.setPhas(null);

		return phaseSubPhaseMapper;
	}

}