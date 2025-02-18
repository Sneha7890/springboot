package com.wipro.springboot.game.model;

import jakarta.persistence.*;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int attempts;

    public Score() {}

    public Score(String name, int attempts) {
        this.name = name;
        this.attempts = attempts;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAttempts() { return attempts; }

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	@Override
    public String toString() {
        return "Score{id=" + id + ", name='" + name + "', attempts=" + attempts + "}";
    }
}
