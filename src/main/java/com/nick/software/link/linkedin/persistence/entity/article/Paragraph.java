package com.nick.software.link.linkedin.persistence.entity.article;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Paragraph {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String body;
}
