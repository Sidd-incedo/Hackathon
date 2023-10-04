package com.capstone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Reg_Users_mapping_table")
public class RegUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MappingId")
    private int mappingId;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "IdeaId")
    private Idea idea;

    @Override
	public String toString() {
		return "RegUsers [mappingId=" + mappingId + ", user=" + user + ", idea=" + idea + "]";
	}

	public int getMappingId() {
        return mappingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }
}

