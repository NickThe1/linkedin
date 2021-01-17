package com.nick.software.link.linkedin.persistence.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobExperienceDto {

    @NotBlank(message = "must be filled in")
    private String position;

    @NotBlank(message = "must be filled in")
    private String about;

    @NotBlank(message = "must be filled in")
    private String technologies;

    @PositiveOrZero(message = "must be > 0")
    private int totalExperience;
}
