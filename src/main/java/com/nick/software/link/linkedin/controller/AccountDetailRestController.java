package com.nick.software.link.linkedin.controller;

import com.nick.software.link.linkedin.persistence.DTO.AccountDetailDto;
import com.nick.software.link.linkedin.service.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0.1/")
public class AccountDetailRestController {

    private AccountDetailService accountDetailService;

    @Autowired
    public AccountDetailRestController(AccountDetailService accountDetailService) {
        this.accountDetailService = accountDetailService;
    }

    @GetMapping("vip/find/{ex}/{page}/{amount}")
    public ResponseEntity<List<AccountDetailDto>> findByTotalExperienceGreaterThanEqual(@PathVariable int ex,
                                                                                        @PathVariable int page,
                                                                                        @PathVariable int amount){
        return new ResponseEntity<>(accountDetailService.findByTotalExperienceGreaterThanEqual(ex, page, amount), HttpStatus.OK);
    }

    @GetMapping("vip/find/less/{ex}/{page}/{amount}")
    public ResponseEntity<List<AccountDetailDto>> findByTotalExperienceLessThanEqual(@PathVariable int ex,
                                                                                        @PathVariable int page,
                                                                                        @PathVariable int amount){
        return new ResponseEntity<>(accountDetailService.findByTotalExperienceLessThanEqual(ex, page, amount), HttpStatus.OK);
    }

    @GetMapping("vip/find/between/{start}/{end}/{page}/{amount}")
    public ResponseEntity<List<AccountDetailDto>> findByTotalExperienceBetween(@PathVariable int start,
                                                                                     @PathVariable int end,
                                                                                     @PathVariable int page,
                                                                                     @PathVariable int amount){
        return new ResponseEntity<>(accountDetailService.findByTotalExperienceBetween(start, end, page, amount), HttpStatus.OK);
    }
}
