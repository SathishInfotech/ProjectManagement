package com.demo.authorizer.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the phase_sub_phase_mapper database table.
 * 
 */
@Entity
@Table(name="phase_sub_phase_mapper")
@NamedQuery(name="PhaseSubPhaseMapper.findAll", query="SELECT p FROM PhaseSubPhaseMapper p")
public class PhaseSubPhaseMapper implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Phas
	@ManyToOne
	@JoinColumn(name="phase_id")
	private Phas phas;

	//bi-directional many-to-one association to SubPhas
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sub_phase_id")
	private SubPhas subPhas;

	//bi-directional many-to-one association to TaskActivityMapper
	@OneToMany(mappedBy="phaseSubPhaseMapper")
	private List<TaskActivityMapper> taskActivityMappers;

	//bi-directional many-to-one association to TaskActivitySchedule
	@OneToMany(mappedBy="phaseSubPhaseMapper")
	private List<TaskActivitySchedule> taskActivitySchedules;

	//bi-directional many-to-one association to TimeTracker
	@OneToMany(mappedBy="phaseSubPhaseMapper")
	private List<TimeTracker> timeTrackers;

	public PhaseSubPhaseMapper() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Phas getPhas() {
		return this.phas;
	}

	public void setPhas(Phas phas) {
		this.phas = phas;
	}

	public SubPhas getSubPhas() {
		return this.subPhas;
	}

	public void setSubPhas(SubPhas subPhas) {
		this.subPhas = subPhas;
	}

	public List<TaskActivityMapper> getTaskActivityMappers() {
		return this.taskActivityMappers;
	}

	public void setTaskActivityMappers(List<TaskActivityMapper> taskActivityMappers) {
		this.taskActivityMappers = taskActivityMappers;
	}

	public TaskActivityMapper addTaskActivityMapper(TaskActivityMapper taskActivityMapper) {
		getTaskActivityMappers().add(taskActivityMapper);
		taskActivityMapper.setPhaseSubPhaseMapper(this);

		return taskActivityMapper;
	}

	public TaskActivityMapper removeTaskActivityMapper(TaskActivityMapper taskActivityMapper) {
		getTaskActivityMappers().remove(taskActivityMapper);
		taskActivityMapper.setPhaseSubPhaseMapper(null);

		return taskActivityMapper;
	}

	public List<TaskActivitySchedule> getTaskActivitySchedules() {
		return this.taskActivitySchedules;
	}

	public void setTaskActivitySchedules(List<TaskActivitySchedule> taskActivitySchedules) {
		this.taskActivitySchedules = taskActivitySchedules;
	}

	public TaskActivitySchedule addTaskActivitySchedule(TaskActivitySchedule taskActivitySchedule) {
		getTaskActivitySchedules().add(taskActivitySchedule);
		taskActivitySchedule.setPhaseSubPhaseMapper(this);

		return taskActivitySchedule;
	}

	public TaskActivitySchedule removeTaskActivitySchedule(TaskActivitySchedule taskActivitySchedule) {
		getTaskActivitySchedules().remove(taskActivitySchedule);
		taskActivitySchedule.setPhaseSubPhaseMapper(null);

		return taskActivitySchedule;
	}

	public List<TimeTracker> getTimeTrackers() {
		return this.timeTrackers;
	}

	public void setTimeTrackers(List<TimeTracker> timeTrackers) {
		this.timeTrackers = timeTrackers;
	}

	public TimeTracker addTimeTracker(TimeTracker timeTracker) {
		getTimeTrackers().add(timeTracker);
		timeTracker.setPhaseSubPhaseMapper(this);

		return timeTracker;
	}

	public TimeTracker removeTimeTracker(TimeTracker timeTracker) {
		getTimeTrackers().remove(timeTracker);
		timeTracker.setPhaseSubPhaseMapper(null);

		return timeTracker;
	}

}