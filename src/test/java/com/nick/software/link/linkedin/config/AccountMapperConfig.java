package com.nick.software.link.linkedin.config;

import com.nick.software.link.linkedin.persistence.DTO.AccountDto;
import com.nick.software.link.linkedin.persistence.entity.Account;
import com.nick.software.link.linkedin.persistence.mapping.AccountMapper;
import com.nick.software.link.linkedin.persistence.mapping.AccountMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountMapperConfig {

    @Bean
    public AccountMapperImpl getAccount(AccountMapperImpl accountMapper){
        return accountMapper;
    }

    @Bean
    public Account getAccount(Account account){
        return account;
    }

    @Bean
    public AccountDto getAccountDto(AccountDto accountDto){
        return accountDto;
    }
}
