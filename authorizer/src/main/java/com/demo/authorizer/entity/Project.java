package com.demo.authorizer.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id")
	private int projectId;

	@Column(name = "project_desc")
	private String projectDesc;

	@Column(name = "project_name")
	private String projectName;

	// bi-directional many-to-many association to User
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "project_users", joinColumns = { @JoinColumn(name = "project_id") }, inverseJoinColumns = {
			@JoinColumn(name = "id") })
	private List<User> users;

	// bi-directional many-to-one association to ProjectUser
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<ProjectUser> projectUsers;

	// bi-directional many-to-one association to Task
	@OneToMany(mappedBy = "project")
	private List<Task> tasks;

	public Project() {
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectDesc() {
		return this.projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<ProjectUser> getProjectUsers() {
		return this.projectUsers;
	}

	public void setProjectUsers(List<ProjectUser> projectUsers) {
		this.projectUsers = projectUsers;
	}

	public ProjectUser addProjectUser(ProjectUser projectUser) {
		getProjectUsers().add(projectUser);
		projectUser.setProject(this);

		return projectUser;
	}

	public ProjectUser removeProjectUser(ProjectUser projectUser) {
		getProjectUsers().remove(projectUser);
		projectUser.setProject(null);

		return projectUser;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setProject(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setProject(null);

		return task;
	}

}