package com.demo.authorizer.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the task_activity_mapper database table.
 * 
 */
@Entity
@Table(name="task_activity_mapper")
@NamedQuery(name="TaskActivityMapper.findAll", query="SELECT t FROM TaskActivityMapper t")
public class TaskActivityMapper implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private BigDecimal estimate;

	@Column(name="planned_start_date")
	private String plannedStartDate;

	//bi-directional many-to-one association to Activity
	@ManyToOne
	@JoinColumn(name="activity_id")
	private Activity activity;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="task_id")
	private Task task;

	//bi-directional many-to-one association to PhaseSubPhaseMapper
	@ManyToOne
	@JoinColumn(name="phase_sub_phase_id")
	private PhaseSubPhaseMapper phaseSubPhaseMapper;

	//bi-directional many-to-one association to TaskActivitySchedule
	@OneToMany(mappedBy="taskActivityMapper")
	private List<TaskActivitySchedule> taskActivitySchedules;

	//bi-directional many-to-one association to TimeTracker
	@OneToMany(mappedBy="taskActivityMapper")
	private List<TimeTracker> timeTrackers;

	public TaskActivityMapper() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getEstimate() {
		return this.estimate;
	}

	public void setEstimate(BigDecimal estimate) {
		this.estimate = estimate;
	}

	public String getPlannedStartDate() {
		return this.plannedStartDate;
	}

	public void setPlannedStartDate(String plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public PhaseSubPhaseMapper getPhaseSubPhaseMapper() {
		return this.phaseSubPhaseMapper;
	}

	public void setPhaseSubPhaseMapper(PhaseSubPhaseMapper phaseSubPhaseMapper) {
		this.phaseSubPhaseMapper = phaseSubPhaseMapper;
	}

	public List<TaskActivitySchedule> getTaskActivitySchedules() {
		return this.taskActivitySchedules;
	}

	public void setTaskActivitySchedules(List<TaskActivitySchedule> taskActivitySchedules) {
		this.taskActivitySchedules = taskActivitySchedules;
	}

	public TaskActivitySchedule addTaskActivitySchedule(TaskActivitySchedule taskActivitySchedule) {
		getTaskActivitySchedules().add(taskActivitySchedule);
		taskActivitySchedule.setTaskActivityMapper(this);

		return taskActivitySchedule;
	}

	public TaskActivitySchedule removeTaskActivitySchedule(TaskActivitySchedule taskActivitySchedule) {
		getTaskActivitySchedules().remove(taskActivitySchedule);
		taskActivitySchedule.setTaskActivityMapper(null);

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
		timeTracker.setTaskActivityMapper(this);

		return timeTracker;
	}

	public TimeTracker removeTimeTracker(TimeTracker timeTracker) {
		getTimeTrackers().remove(timeTracker);
		timeTracker.setTaskActivityMapper(null);

		return timeTracker;
	}

}