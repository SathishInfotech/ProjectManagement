package com.demo.authorizer.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tasks database table.
 * 
 */
@Entity
@Table(name="tasks")
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="task_id")
	private int taskId;

	@Column(name="task_name")
	private String taskName;

	//bi-directional many-to-one association to TaskActivityMapper
	@OneToMany(mappedBy="task")
	private List<TaskActivityMapper> taskActivityMappers;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Task() {
	}

	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public List<TaskActivityMapper> getTaskActivityMappers() {
		return this.taskActivityMappers;
	}

	public void setTaskActivityMappers(List<TaskActivityMapper> taskActivityMappers) {
		this.taskActivityMappers = taskActivityMappers;
	}

	public TaskActivityMapper addTaskActivityMapper(TaskActivityMapper taskActivityMapper) {
		getTaskActivityMappers().add(taskActivityMapper);
		taskActivityMapper.setTask(this);

		return taskActivityMapper;
	}

	public TaskActivityMapper removeTaskActivityMapper(TaskActivityMapper taskActivityMapper) {
		getTaskActivityMappers().remove(taskActivityMapper);
		taskActivityMapper.setTask(null);

		return taskActivityMapper;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}