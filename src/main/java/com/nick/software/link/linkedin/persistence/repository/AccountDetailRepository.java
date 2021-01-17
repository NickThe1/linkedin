package com.nick.software.link.linkedin.persistence.repository;

import com.nick.software.link.linkedin.persistence.entity.AccountDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDetailRepository extends JpaRepository<AccountDetail, Long> {

    List<AccountDetail> findByTotalExperienceGreaterThanEqual(int totalExperience, Pageable pageable);

    List<AccountDetail> findByTotalExperienceLessThanEqual(int totalExperience, Pageable pageable);

    List<AccountDetail> findByTotalExperienceBetween(int start, int end, Pageable pageable);
}
