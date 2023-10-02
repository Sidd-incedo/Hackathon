package com.capstone.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Panel")
public class Panel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PanelistID")
	private int panelistId;
	@OneToMany(mappedBy = "Panel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PanelistIdeaMapping> panelistideamapping = new HashSet<>();
	@OneToOne
	@JoinColumn(name = "UserID", referencedColumnName = "UserID", insertable = false, updatable = false)
	private User userId;
}