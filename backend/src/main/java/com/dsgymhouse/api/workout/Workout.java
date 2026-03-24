package com.dsgymhouse.api.workout;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String goal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkoutLevel level;

    @Column(nullable = false)
    private Integer durationMinutes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkoutFormat format;

    @Column(columnDefinition = "TEXT")
    private String instructions;

    private String contentUrl;

    @Column(nullable = false)
    private boolean published = true;

    public Workout() {
    }

    public Workout(String title,
                   String goal,
                   WorkoutLevel level,
                   Integer durationMinutes,
                   WorkoutFormat format,
                   String instructions,
                   String contentUrl,
                   boolean published) {
        this.title = title;
        this.goal = goal;
        this.level = level;
        this.durationMinutes = durationMinutes;
        this.format = format;
        this.instructions = instructions;
        this.contentUrl = contentUrl;
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public WorkoutLevel getLevel() {
        return level;
    }

    public void setLevel(WorkoutLevel level) {
        this.level = level;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public WorkoutFormat getFormat() {
        return format;
    }

    public void setFormat(WorkoutFormat format) {
        this.format = format;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public enum WorkoutFormat {
        video,
        external_link,
        text
    }

    public enum WorkoutLevel {
        iniciante,
        intermediario,
        avancado
    }
}