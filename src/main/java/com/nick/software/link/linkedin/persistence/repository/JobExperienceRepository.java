package com.nick.software.link.linkedin.persistence.repository;

import com.nick.software.link.linkedin.persistence.entity.JobExperience;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobExperienceRepository extends JpaRepository<JobExperience, Long> {

    List<JobExperience> findByTechnologiesContaining(String tech, Pageable pageable);

    List<JobExperience> findByPositionContaining(String position, Pageable pageable);
}
