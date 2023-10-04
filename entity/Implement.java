package com.capstone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Implementation")
public class Implement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Impl_Id")
    private int implId;

    @Column(name = "Impl_description")
    private String implDescription;

    @Column(name = "Documentation")
    private String documentation;

    @ManyToOne
    @JoinColumn(name = "IdeaId")
    private Idea idea;

    @Override
	public String toString() {
		return "Implement [implId=" + implId + ", implDescription=" + implDescription + ", documentation="
				+ documentation + ", idea=" + idea + "]";
	}

	public int getImplId() {
        return implId;
    }

    public String getImplDescription() {
        return implDescription;
    }

    public void setImplDescription(String implDescription) {
        this.implDescription = implDescription;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }
}
