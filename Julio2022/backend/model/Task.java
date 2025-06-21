package Julio2022.backend.model;

import javax.annotation.processing.Generated;

public class Task {
    @GeneratedType(...)
    private Long id;

    private String description;

    // Constructor, getters, setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
