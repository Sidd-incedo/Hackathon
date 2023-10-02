package com.capstone.entity;

import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID")
	private int uId;

	@Column(name = "Name")
	private String name;
	@Column(name = "Email", unique = true)
	private String email;
	@Column(name = "Password")
	private String password;
	@Column(name = "PhoneNo", unique = true)
	private int phone;

	@OneToOne(mappedBy="Users", cascade=CascadeType.ALL)
	private Panel panelist;

	@ManyToOne
	@JoinColumn(name = "RoleID")
	private Role role;// 1.participant(leader),2.teamMem,3.panelist,4.judge

	@OneToMany(mappedBy = "Users", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<RegUsers> userIdeaMappings = new HashSet<>();

	public Role getRoleId() {
		return role;
	}

	public void setRoleId(Role roleId) {
		this.role = roleId;
	}

	public Set<RegUsers> getUserIdeaMappings() {
		return userIdeaMappings;
	}

	public void setUserIdeaMappings(Set<RegUsers> userIdeaMappings) {
		this.userIdeaMappings = userIdeaMappings;
	}

	public void addUserIdeaMapping(RegUsers userIdeaMapping) {
		userIdeaMappings.add(userIdeaMapping);
		userIdeaMapping.setUser(this);
	}

	public void removeUserIdeaMapping(RegUsers userIdeaMapping) {
		userIdeaMappings.remove(userIdeaMapping);
		userIdeaMapping.setUser(null);
	}

	public int getId() {
		return uId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
