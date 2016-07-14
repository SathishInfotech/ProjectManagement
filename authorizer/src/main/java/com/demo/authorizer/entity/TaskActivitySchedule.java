package com.demo.authorizer.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the task_activity_schedule database table.
 * 
 */
@Entity
@Table(name="task_activity_schedule")
@NamedQuery(name="TaskActivitySchedule.findAll", query="SELECT t FROM TaskActivitySchedule t")
public class TaskActivitySchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="actual_end_date")
	private Date actualEndDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="actual_start_date")
	private Date actualStartDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="planned_end_date")
	private Date plannedEndDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="planned_start_date")
	private Date plannedStartDate;

	private int poc;

	private int sequence;

	@Column(name="task_activity_status")
	private String taskActivityStatus;

	//bi-directional many-to-one association to PhaseSubPhaseMapper
	@ManyToOne
	@JoinColumn(name="phase_sub_phase_id")
	private PhaseSubPhaseMapper phaseSubPhaseMapper;

	//bi-directional many-to-one association to TaskActivityMapper
	@ManyToOne
	@JoinColumn(name="task_activity_id")
	private TaskActivityMapper taskActivityMapper;

	public TaskActivitySchedule() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getActualEndDate() {
		return this.actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public Date getActualStartDate() {
		return this.actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getPlannedEndDate() {
		return this.plannedEndDate;
	}

	public void setPlannedEndDate(Date plannedEndDate) {
		this.plannedEndDate = plannedEndDate;
	}

	public Date getPlannedStartDate() {
		return this.plannedStartDate;
	}

	public void setPlannedStartDate(Date plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}

	public int getPoc() {
		return this.poc;
	}

	public void setPoc(int poc) {
		this.poc = poc;
	}

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getTaskActivityStatus() {
		return this.taskActivityStatus;
	}

	public void setTaskActivityStatus(String taskActivityStatus) {
		this.taskActivityStatus = taskActivityStatus;
	}

	public PhaseSubPhaseMapper getPhaseSubPhaseMapper() {
		return this.phaseSubPhaseMapper;
	}

	public void setPhaseSubPhaseMapper(PhaseSubPhaseMapper phaseSubPhaseMapper) {
		this.phaseSubPhaseMapper = phaseSubPhaseMapper;
	}

	public TaskActivityMapper getTaskActivityMapper() {
		return this.taskActivityMapper;
	}

	public void setTaskActivityMapper(TaskActivityMapper taskActivityMapper) {
		this.taskActivityMapper = taskActivityMapper;
	}

}