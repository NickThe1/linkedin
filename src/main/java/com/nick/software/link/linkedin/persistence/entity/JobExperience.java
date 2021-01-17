package com.nick.software.link.linkedin.persistence.entity;

import com.nick.software.link.linkedin.persistence.DTO.JobExperienceDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String position;

    private String about;

    private String technologies;

    private int totalExperience;
}
