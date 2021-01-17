package com.nick.software.link.linkedin.controller;

import com.nick.software.link.linkedin.JWT.JwtTokenProvider;
import com.nick.software.link.linkedin.exception.ApiError;
import com.nick.software.link.linkedin.persistence.DTO.AuthenticationRequestDto;
import com.nick.software.link.linkedin.persistence.entity.Account;
import com.nick.software.link.linkedin.persistence.entity.Role;
import com.nick.software.link.linkedin.persistence.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/v0.1/auth/")
public class AuthenticationRequestRestController {

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private AccountRepository userRepo;

    @Autowired
    public AuthenticationRequestRestController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, AccountRepository userRepo) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepo = userRepo;
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDto requestDto){
        try{
            String username = requestDto.getUsername();
            Optional<Account> userOptional = userRepo.findByUsername(username);
            if (!userOptional.isPresent()){
                String errorMessage = "User with name " + username + " not found";
                ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, errorMessage);
                return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
            }
            authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(username,
                            requestDto.getPassword()));
            Set<Role> roles = new HashSet<>(userOptional.get().getRole());
            String token = jwtTokenProvider.createToken(username, roles);
            Map<Object,Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);
            return ResponseEntity.ok(response);
        }catch (AuthenticationException e){
            ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, e.getMessage());
            return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
        }
    }

}
