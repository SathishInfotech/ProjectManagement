package com.demo.authorizer.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the activity database table.
 * 
 */
@Entity
@NamedQuery(name="Activity.findAll", query="SELECT a FROM Activity a")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="activity_id")
	private int activityId;

	@Column(name="activity_name")
	private String activityName;

	//bi-directional many-to-one association to TaskActivityMapper
	@OneToMany(mappedBy="activity")
	private List<TaskActivityMapper> taskActivityMappers;

	public Activity() {
	}

	public int getActivityId() {
		return this.activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public List<TaskActivityMapper> getTaskActivityMappers() {
		return this.taskActivityMappers;
	}

	public void setTaskActivityMappers(List<TaskActivityMapper> taskActivityMappers) {
		this.taskActivityMappers = taskActivityMappers;
	}

	public TaskActivityMapper addTaskActivityMapper(TaskActivityMapper taskActivityMapper) {
		getTaskActivityMappers().add(taskActivityMapper);
		taskActivityMapper.setActivity(this);

		return taskActivityMapper;
	}

	public TaskActivityMapper removeTaskActivityMapper(TaskActivityMapper taskActivityMapper) {
		getTaskActivityMappers().remove(taskActivityMapper);
		taskActivityMapper.setActivity(null);

		return taskActivityMapper;
	}

}