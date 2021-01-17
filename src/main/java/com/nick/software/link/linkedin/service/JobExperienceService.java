package com.nick.software.link.linkedin.service;

import com.nick.software.link.linkedin.persistence.DTO.JobExperienceDto;
import com.nick.software.link.linkedin.persistence.mapping.JobExperienceMapper;
import com.nick.software.link.linkedin.persistence.repository.JobExperienceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class JobExperienceService {

    private JobExperienceRepository jobExperienceRepository;

    @Autowired
    public JobExperienceService(JobExperienceRepository jobExperienceRepository) {
        this.jobExperienceRepository = jobExperienceRepository;
    }

    public List<JobExperienceDto> findByTechnologiesContaining(String tech, int page, int amount){
        Pageable pageable = PageRequest.of(page, amount, Sort.by("totalExperience").descending());
        return JobExperienceMapper.INSTANCE.entityToDto(jobExperienceRepository.findByTechnologiesContaining(tech, pageable));
    }

    public List<JobExperienceDto> findByPositionContaining(String position, int page, int amount){
        Pageable pageable = PageRequest.of(page, amount, Sort.by("totalExperience").descending());
        return JobExperienceMapper.INSTANCE.entityToDto(jobExperienceRepository.findByPositionContaining(position,pageable));
    }
}
