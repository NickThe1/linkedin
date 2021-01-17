package com.nick.software.link.linkedin.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class AccountDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstname;

    private String lastname;

    private String middlename;

    private String contact;

    private String about;

    private int totalExperience;

    @OneToMany(fetch = FetchType.EAGER)
    private List<JobExperience> jobExperiences;

    @OneToOne(fetch = FetchType.LAZY)
    private Account account;
}
