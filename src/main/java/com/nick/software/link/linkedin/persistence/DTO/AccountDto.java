package com.nick.software.link.linkedin.persistence.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDto {

    @Email
    private String email;

    @NotBlank(message = "must be filled in")
    private String username;

    @Min(value = 10, message = "too short password")
    private String password;
}
