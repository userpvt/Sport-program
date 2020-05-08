package by.project.entity;

import lombok.Getter;

@Getter
public enum Level {

    EASY("Лёгкий"),
    MEDIUM("Средний"),
    HARD("Тяжёлый"),
    HARDCORE("Гладиатор");

    private final String description;

    Level(String description) {
        this.description = description;
    }
}