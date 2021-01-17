package com.nick.software.link.linkedin.persistence.DTO.article;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentDto {

    @NotBlank(message = "empty comment")
    private String body;
}
