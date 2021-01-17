package com.nick.software.link.linkedin.persistence.DTO.article;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDto {

    @NotBlank(message = "must be filled in")
    private String title;

    @NotBlank(message = "must be filled in")
    private String keywords;

    @NotNull(message = "must have paragraphs")
    private List<ParagraphDto> paragraphDtos;
}
