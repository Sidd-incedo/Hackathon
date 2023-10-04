package com.capstone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Panelist_Idea_Mapping_Table")
public class PanelistIdeaMapping {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MappingId")
    private int mappingId;
	@ManyToOne
    @JoinColumn(name = "IdeaId")
    private Idea idea;
	
	@ManyToOne
    @JoinColumn(name = "PanelistID")
    private Panel panel;
	public int getMappingId() {
		return mappingId;
	}
	@Override
	public String toString() {
		return "PanelistIdeaMapping [mappingId=" + mappingId + ", idea=" + idea + ", panel=" + panel + "]";
	}
	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}
}
