package com.nick.software.link.linkedin.controller;

import com.nick.software.link.linkedin.persistence.DTO.JobExperienceDto;
import com.nick.software.link.linkedin.service.JobExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v0.1/")
public class JobExperienceRestController {

    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceRestController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("jobs/find/{tech}/{page}/{amount}")
    public List<JobExperienceDto> findByTechnologiesContaining(@PathVariable String tech,
                                                               @PathVariable int page,
                                                               @PathVariable int amount){
        return jobExperienceService.findByTechnologiesContaining(tech, page, amount);
    }

    @GetMapping("jobs/find/{position}/{page}/{amount}")
    public List<JobExperienceDto> findByPositionContaining(@PathVariable String position,
                                                               @PathVariable int page,
                                                               @PathVariable int amount){
        return jobExperienceService.findByPositionContaining(position, page, amount);
    }
}
