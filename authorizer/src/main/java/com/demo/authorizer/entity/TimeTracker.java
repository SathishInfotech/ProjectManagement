package com.demo.authorizer.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the time_tracker database table.
 * 
 */
@Entity
@Table(name="time_tracker")
@NamedQuery(name="TimeTracker.findAll", query="SELECT t FROM TimeTracker t")
public class TimeTracker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="timesheet_id")
	private int timesheetId;

	private String comments;

	@Column(name="hours_spent")
	private BigDecimal hoursSpent;

	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_date")
	private Date timeDate;

	//bi-directional many-to-one association to TaskActivityMapper
	@ManyToOne
	@JoinColumn(name="task_activity_id")
	private TaskActivityMapper taskActivityMapper;

	//bi-directional many-to-one association to PhaseSubPhaseMapper
	@ManyToOne
	@JoinColumn(name="phase_sub_phase_id")
	private PhaseSubPhaseMapper phaseSubPhaseMapper;

	public TimeTracker() {
	}

	public int getTimesheetId() {
		return this.timesheetId;
	}

	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public BigDecimal getHoursSpent() {
		return this.hoursSpent;
	}

	public void setHoursSpent(BigDecimal hoursSpent) {
		this.hoursSpent = hoursSpent;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTimeDate() {
		return this.timeDate;
	}

	public void setTimeDate(Date timeDate) {
		this.timeDate = timeDate;
	}

	public TaskActivityMapper getTaskActivityMapper() {
		return this.taskActivityMapper;
	}

	public void setTaskActivityMapper(TaskActivityMapper taskActivityMapper) {
		this.taskActivityMapper = taskActivityMapper;
	}

	public PhaseSubPhaseMapper getPhaseSubPhaseMapper() {
		return this.phaseSubPhaseMapper;
	}

	public void setPhaseSubPhaseMapper(PhaseSubPhaseMapper phaseSubPhaseMapper) {
		this.phaseSubPhaseMapper = phaseSubPhaseMapper;
	}

}