package com.web.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//POJO -2006
//POJI

@Entity
@Table(name="user_profiles_tbl")
public class SignupEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lid;
	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	@Column(length=255)
	private String username;
	private String password;
	private String name;
	private String email;
	private String gender;
	private String photo;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "signup_roles_tbl", 
             joinColumns = { @JoinColumn(name = "lid") }, 
             inverseJoinColumns = { @JoinColumn(name = "rid") })
	private List<RoleEntity> roles = new ArrayList<RoleEntity>();

}
