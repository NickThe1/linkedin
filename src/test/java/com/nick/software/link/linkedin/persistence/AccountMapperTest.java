package com.nick.software.link.linkedin.persistence;

import com.nick.software.link.linkedin.config.AccountMapperConfig;
import com.nick.software.link.linkedin.persistence.DTO.AccountDto;
import com.nick.software.link.linkedin.persistence.entity.Account;
import com.nick.software.link.linkedin.persistence.mapping.AccountMapper;
import com.nick.software.link.linkedin.persistence.mapping.AccountMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {Account.class, AccountDto.class, AccountMapperImpl.class})
public class AccountMapperTest {

    @Autowired
    private Account account;

    @Autowired
    private AccountDto accountDto;

    @Autowired
    private AccountMapperImpl accountMapper;

    @BeforeEach
    public void setUp(){
        account = new Account();
        account.setUsername("tester");
        account.setPassword("1234567890");
        account.setEmail("test@mail.ru");

        accountDto = new AccountDto();
        accountDto.setEmail("test@mail.ru");
        accountDto.setUsername("tester");
        accountDto.setPassword("1234567890");
    }

    @Test
    public void dtoToEntity(){
        Account account1 = accountMapper.dtoToEntity(accountDto);
        assertEquals(account1.getUsername(), accountDto.getUsername());
        assertEquals(account1.getPassword(), accountDto.getPassword());
        assertEquals(account1.getEmail(), accountDto.getEmail());
    }
}
