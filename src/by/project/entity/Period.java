package by.project.entity;

import lombok.Getter;

@Getter
public enum Period {

    WEEKLY("Недельный"),
    MONTHLY("Месячный");

    private String description;

    Period(String description) {
        this.description = description;
    }
}