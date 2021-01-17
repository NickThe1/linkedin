package com.nick.software.link.linkedin.persistence.entity.article;

import com.nick.software.link.linkedin.persistence.entity.Account;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String title;

    private String keywords;

    private long likes;

    private long dislikes;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Paragraph> paragraphs;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments;
}
