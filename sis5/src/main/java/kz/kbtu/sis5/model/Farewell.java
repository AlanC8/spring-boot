package kz.kbtu.sis5.model;

import lombok.Data;

@Data
public class Farewell {
    private String message;
    private Integer remainingMinutes;
}