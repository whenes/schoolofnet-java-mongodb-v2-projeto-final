package com.schoolofnet.JavaMongoPF;

import org.springframework.data.annotation.Id;

public class Task {
    @Id
    private String id;
    private String name;

    public Task() {}

    public Task(String name) { this.name = name; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
