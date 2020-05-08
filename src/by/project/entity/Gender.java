package by.project.entity;

import lombok.Getter;

@Getter
public enum Gender {

    MALE("Мужична"),
    FEMALE("Женщина");

    private String description;

    Gender(String description) {
        this.description = description;
    }
}