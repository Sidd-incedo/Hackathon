package com.capstone.entity;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Ideas")
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdeaId")
    private int ideaId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Status")
    private String status;

    @OneToMany(mappedBy = "Ideas", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Implement> implementations = new HashSet<>();

    @OneToMany(mappedBy = "Ideas", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RegUsers> userIdeaMappings = new HashSet<>();
    
    @OneToMany(mappedBy = "Idea", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PanelistIdeaMapping> panelistideamapping = new HashSet<>();

    @Override
	public String toString() {
		return "Idea [ideaId=" + ideaId + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", implementations=" + implementations + ", userIdeaMappings=" + userIdeaMappings + "]";
	}

	public int getIdeaId() {
        return ideaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Implement> getImplementations() {
        return implementations;
    }

    public void setImplementations(Set<Implement> implementations) {
        this.implementations = implementations;
    }

    public void addImplementation(Implement implementation) {
        implementations.add(implementation);
        implementation.setIdea(this);
    }

    public void removeImplementation(Implement implementation) {
        implementations.remove(implementation);
        implementation.setIdea(null);
    }

    public Set<RegUsers> getUserIdeaMappings() {
        return userIdeaMappings;
    }

    public void setUserIdeaMappings(Set<RegUsers> userIdeaMappings) {
        this.userIdeaMappings = userIdeaMappings;
    }

    public void addUserIdeaMapping(RegUsers userIdeaMapping) {
        userIdeaMappings.add(userIdeaMapping);
        userIdeaMapping.setIdea(this);
    }

    public void removeUserIdeaMapping(RegUsers userIdeaMapping) {
        userIdeaMappings.remove(userIdeaMapping);
        userIdeaMapping.setIdea(null);
    }
}
