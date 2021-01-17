package com.nick.software.link.linkedin.persistence.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDetailDto {

    @NotBlank(message = "must be filled in")
    private String firstname;

    @NotBlank(message = "must be filled in")
    private String lastname;

    @NotBlank(message = "must be filled in")
    private String middlename;

    @NotBlank(message = "must be filled in")
    private String contact;

    @NotBlank(message = "must be filled in")
    private String about;

    private List<JobExperienceDto> jobExperienceDtos;
}
