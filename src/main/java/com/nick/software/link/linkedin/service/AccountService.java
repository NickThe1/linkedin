package com.nick.software.link.linkedin.service;

import com.nick.software.link.linkedin.persistence.DTO.AccountDto;
import com.nick.software.link.linkedin.persistence.entity.Account;
import com.nick.software.link.linkedin.persistence.entity.AccountDetail;
import com.nick.software.link.linkedin.persistence.entity.Role;
import com.nick.software.link.linkedin.persistence.mapping.AccountMapper;
import com.nick.software.link.linkedin.persistence.repository.AccountDetailRepository;
import com.nick.software.link.linkedin.persistence.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

@Slf4j
@Service
public class AccountService {

    private AccountRepository accountRepository;

    private AccountDetailRepository accountDetailRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AccountService(AccountRepository accountRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AccountDetailRepository accountDetailRepository) {
        this.accountRepository = accountRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.accountDetailRepository = accountDetailRepository;
    }

    public void createAccount(AccountDto accountDto){
        Account account = AccountMapper.INSTANCE.dtoToEntity(accountDto);



            account.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));

            //wires account and it's detail
            AccountDetail accountDetail = new AccountDetail();
            account.setAccountDetail(accountDetail);
            accountDetailRepository.save(accountDetail);

            account.setRole(new HashSet<>(Collections.singleton(Role.USER)));
            accountRepository.save(account);

            log.info("account created");


    }

    public AccountDto findByUsername(String username){
        return AccountMapper.INSTANCE.entityToDto(accountRepository.findByUsername(username).get());
    }

    public void updateById(long id, AccountDto accountDto){
        Optional<Account> account = accountRepository.findById(id);

        if (account.isPresent()){
            log.info("username updated", account);
        }
    }
}