package com.demo.authorizer.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private boolean enabled;

    private String password;

    private String username;

    // bi-directional many-to-one association to UserRole
    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles;

    // bi-directional many-to-many association to Project
    @ManyToMany(mappedBy = "users")
    private List<Project> projects;

    // bi-directional many-to-one association to ProjectUser
    @OneToMany(mappedBy = "user1")
    private List<ProjectUser> projectUsers1;

    // bi-directional many-to-one association to Task
    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

/*    @Column(name = "user_id")
    private String userId;
*/
/*    public String getUserId() {
	return userId;
    }
*/
    public List<Project> getProjects() {
	return projects;
    }

    public void setProjects(List<Project> projects) {
	this.projects = projects;
    }

    public List<ProjectUser> getProjectUsers1() {
	return projectUsers1;
    }

    public void setProjectUsers1(List<ProjectUser> projectUsers1) {
	this.projectUsers1 = projectUsers1;
    }

    public List<Task> getTasks() {
	return tasks;
    }

    public void setTasks(List<Task> tasks) {
	this.tasks = tasks;
    }

 /*   public void setUserId(String userId) {
	this.userId = userId;
    }
*/
    public User() {
    }

    public int getId() {
	return this.id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getUsername() {
	return this.username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public List<UserRole> getUserRoles() {
	return this.userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
	this.userRoles = userRoles;
    }

    public UserRole addUserRole(UserRole userRole) {
	getUserRoles().add(userRole);
	userRole.setUser(this);

	return userRole;
    }

    public UserRole removeUserRole(UserRole userRole) {
	getUserRoles().remove(userRole);
	userRole.setUser(null);

	return userRole;
    }

    public ProjectUser addProjectUsers1(ProjectUser projectUsers1) {
	getProjectUsers1().add(projectUsers1);
	projectUsers1.setUser1(this);

	return projectUsers1;
    }

    public ProjectUser removeProjectUsers1(ProjectUser projectUsers1) {
	getProjectUsers1().remove(projectUsers1);
	projectUsers1.setUser1(null);

	return projectUsers1;
    }

}