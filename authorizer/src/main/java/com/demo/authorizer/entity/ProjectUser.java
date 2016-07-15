package com.demo.authorizer.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the project_users database table.
 * 
 */
@Entity
@Table(name = "project_users")
@NamedQuery(name = "ProjectUser.findAll", query = "SELECT p FROM ProjectUser p")
public class ProjectUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // bi-directional many-to-one association to Project
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    // bi-directional many-to-one association to User
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id",insertable=false,updatable=false)
    private User user1;

    
    public ProjectUser() {
    }

    public int getId() {
	return this.id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public Project getProject() {
	return this.project;
    }

    public void setProject(Project project) {
	this.project = project;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }
}