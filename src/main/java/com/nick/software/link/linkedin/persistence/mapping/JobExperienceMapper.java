package com.nick.software.link.linkedin.persistence.mapping;

import com.nick.software.link.linkedin.persistence.DTO.JobExperienceDto;
import com.nick.software.link.linkedin.persistence.entity.JobExperience;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JobExperienceMapper {

    JobExperienceMapper INSTANCE = Mappers.getMapper(JobExperienceMapper.class);

    JobExperience dtoToEntity(JobExperienceDto jobExperienceDto);

    JobExperienceDto entityToDto(JobExperience jobExperience);

    List<JobExperienceDto> entityToDto(List<JobExperience> jobExperiences);
}
