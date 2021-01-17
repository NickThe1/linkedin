package com.nick.software.link.linkedin.persistence.repository;

import com.nick.software.link.linkedin.persistence.entity.article.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByTitle(String title);

    List<Post> findByKeywordsContaining(String keyword, Pageable pageable);

    List<Post> findByLikesGreaterThanEqualAndDislikesGreaterThanEqual(int likes, int dislikes);
}
