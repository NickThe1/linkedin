package com.nick.software.link.linkedin.controller;

import com.nick.software.link.linkedin.persistence.DTO.AccountDto;
import com.nick.software.link.linkedin.persistence.DTO.article.CommentDto;
import com.nick.software.link.linkedin.persistence.DTO.article.PostDto;
import com.nick.software.link.linkedin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v0.1/")
public class AccountRestController {

    private AccountService accountService;

    @Autowired
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/auth")
    public ResponseEntity<AccountDto> register(@RequestBody AccountDto accountDto){
        accountService.createAccount(accountDto);
        return new ResponseEntity<AccountDto>(accountDto, HttpStatus.CREATED);
    }

    @GetMapping("/user/username/{username}")
    public ResponseEntity<AccountDto> findByUsername(@PathVariable String username){
        return new ResponseEntity<>(accountService.findByUsername(username),HttpStatus.OK);
    }

    @PutMapping("/user/update/username_id/{id}")
    public ResponseEntity<?> updateById(@PathVariable long id, @RequestBody AccountDto accountDto){
        accountService.updateById(id, accountDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/user/{id}/post")
    public ResponseEntity<?> createPost(@PathVariable long id, @Valid @RequestBody PostDto postDto){
        accountService.createPost(id, postDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/user/{id}/post/{title}/comment")
    public ResponseEntity<?> createPost(@PathVariable long id, @PathVariable String title, @Valid @RequestBody CommentDto postDto){
        accountService.createComment(id, title, postDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
