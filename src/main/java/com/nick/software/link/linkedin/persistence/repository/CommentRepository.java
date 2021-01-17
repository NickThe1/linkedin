package com.nick.software.link.linkedin.persistence.repository;

import com.nick.software.link.linkedin.persistence.entity.Account;
import com.nick.software.link.linkedin.persistence.entity.article.Comment;
import com.nick.software.link.linkedin.persistence.entity.article.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByAccount(Account account);

    List<Comment> findByPost(Post post);

    List<Comment> findByBodyContaining(String body);
}
