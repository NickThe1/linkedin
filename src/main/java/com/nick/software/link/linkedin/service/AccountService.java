package com.nick.software.link.linkedin.service;

import com.nick.software.link.linkedin.exception.AccountExistsException;
import com.nick.software.link.linkedin.exception.AccountNotFoundException;
import com.nick.software.link.linkedin.persistence.DTO.AccountDto;
import com.nick.software.link.linkedin.persistence.DTO.article.PostDto;
import com.nick.software.link.linkedin.persistence.entity.Account;
import com.nick.software.link.linkedin.persistence.entity.AccountDetail;
import com.nick.software.link.linkedin.persistence.entity.Role;
import com.nick.software.link.linkedin.persistence.entity.article.Post;
import com.nick.software.link.linkedin.persistence.mapping.AccountMapper;
import com.nick.software.link.linkedin.persistence.mapping.PostMapper;
import com.nick.software.link.linkedin.persistence.repository.AccountDetailRepository;
import com.nick.software.link.linkedin.persistence.repository.AccountRepository;
import com.nick.software.link.linkedin.persistence.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AccountService {

    private AccountRepository accountRepository;

    private AccountDetailRepository accountDetailRepository;

    private PostRepository postRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AccountService(AccountRepository accountRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AccountDetailRepository accountDetailRepository, PostRepository postRepository) {
        this.accountRepository = accountRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.accountDetailRepository = accountDetailRepository;
        this.postRepository = postRepository;
    }

    public void createAccount(AccountDto accountDto){
        Account account = AccountMapper.INSTANCE.dtoToEntity(accountDto);

        if (accountRepository.findById(account.getId()).isPresent()) throw new AccountExistsException(String.valueOf(account.getId()));

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
        return AccountMapper.INSTANCE.entityToDto(accountRepository.findByUsername(username).orElseThrow(
                () -> new AccountNotFoundException(username)));
    }

    public void updateById(long id, AccountDto accountDto){
        Optional<Account> account = accountRepository.findById(id);

        if (account.isPresent()){
            log.info("username updated", account);
        }else  throw new AccountNotFoundException(String.valueOf(id));
    }

    public void createPost(long id,PostDto postDto){
        if (postRepository.findByTitle(postDto.getTitle()).isPresent()) throw new RuntimeException("post exists");

        Post post = PostMapper.INSTANCE.dtoToEntity(postDto);
        Account account = accountRepository.findById(id).orElseThrow( () -> new AccountNotFoundException(String.valueOf(id)) );

        List<Post> posts = account.getPosts();
        posts.add(post);
        post.setAccount(account);
        postRepository.save(post);

        log.info("Post added " + postDto.getTitle());
    }
}
