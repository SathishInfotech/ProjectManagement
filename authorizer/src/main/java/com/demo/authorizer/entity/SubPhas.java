package com.demo.authorizer.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sub_phases database table.
 * 
 */
@Entity
@Table(name="sub_phases")
@NamedQuery(name="SubPhas.findAll", query="SELECT s FROM SubPhas s")
public class SubPhas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sub_phase_id")
	private int subPhaseId;

	@Column(name="sub_phase_name")
	private String subPhaseName;

	//bi-directional many-to-one association to PhaseSubPhaseMapper
	@OneToMany(mappedBy="subPhas")
	private List<PhaseSubPhaseMapper> phaseSubPhaseMappers;

	public SubPhas() {
	}

	public int getSubPhaseId() {
		return this.subPhaseId;
	}

	public void setSubPhaseId(int subPhaseId) {
		this.subPhaseId = subPhaseId;
	}

	public String getSubPhaseName() {
		return this.subPhaseName;
	}

	public void setSubPhaseName(String subPhaseName) {
		this.subPhaseName = subPhaseName;
	}

	public List<PhaseSubPhaseMapper> getPhaseSubPhaseMappers() {
		return this.phaseSubPhaseMappers;
	}

	public void setPhaseSubPhaseMappers(List<PhaseSubPhaseMapper> phaseSubPhaseMappers) {
		this.phaseSubPhaseMappers = phaseSubPhaseMappers;
	}

	public PhaseSubPhaseMapper addPhaseSubPhaseMapper(PhaseSubPhaseMapper phaseSubPhaseMapper) {
		getPhaseSubPhaseMappers().add(phaseSubPhaseMapper);
		phaseSubPhaseMapper.setSubPhas(this);

		return phaseSubPhaseMapper;
	}

	public PhaseSubPhaseMapper removePhaseSubPhaseMapper(PhaseSubPhaseMapper phaseSubPhaseMapper) {
		getPhaseSubPhaseMappers().remove(phaseSubPhaseMapper);
		phaseSubPhaseMapper.setSubPhas(null);

		return phaseSubPhaseMapper;
	}

}