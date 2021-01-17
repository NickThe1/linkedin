package com.nick.software.link.linkedin.service;

import com.nick.software.link.linkedin.persistence.DTO.AccountDetailDto;
import com.nick.software.link.linkedin.persistence.entity.AccountDetail;
import com.nick.software.link.linkedin.persistence.mapping.AccountDetailMapper;
import com.nick.software.link.linkedin.persistence.repository.AccountDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccountDetailService {

    private AccountDetailRepository accountDetailRepository;

    @Autowired
    public AccountDetailService(AccountDetailRepository accountDetailRepository) {
        this.accountDetailRepository = accountDetailRepository;
    }

    public void setAccountDetail(long id, AccountDetailDto accountDetailDto){
        if(accountDetailRepository.findById(id).isPresent()){
            AccountDetail accountDetail = accountDetailRepository.findById(id).get();
            accountDetail = AccountDetailMapper.INSTANCE.droToEntity(accountDetailDto);
            accountDetailRepository.save(accountDetail);
            log.info("account details updated", accountDetail);
        }
    }

    public List<AccountDetailDto> findByTotalExperienceGreaterThanEqual(int experience, int page, int amount){
        Pageable pageable = PageRequest.of(page, amount, Sort.by("totalExperience").descending());
        return AccountDetailMapper.INSTANCE.entityToDto(accountDetailRepository.findByTotalExperienceGreaterThanEqual(experience, pageable));
    }

    public List<AccountDetailDto> findByTotalExperienceLessThanEqual(int experience, int page, int amount){
        Pageable pageable = PageRequest.of(page, amount, Sort.by("totalExperience").descending());
        return AccountDetailMapper.INSTANCE.entityToDto(accountDetailRepository.findByTotalExperienceLessThanEqual(experience, pageable));
    }

    public List<AccountDetailDto> findByTotalExperienceBetween(int start, int end, int page, int amount){
        Pageable pageable = PageRequest.of(page, amount, Sort.by("totalExperience").descending());
        return AccountDetailMapper.INSTANCE.entityToDto(accountDetailRepository.findByTotalExperienceBetween(start, end, pageable));
    }
}
