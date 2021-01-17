package com.nick.software.link.linkedin.service.article;

import com.nick.software.link.linkedin.persistence.DTO.article.PostDto;
import com.nick.software.link.linkedin.persistence.entity.article.Post;
import com.nick.software.link.linkedin.persistence.mapping.PostMapper;
import com.nick.software.link.linkedin.persistence.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(PostDto postDto){
        Post post = PostMapper.INSTANCE.dtoToEntity(postDto);
        postRepository.save(post);
    }

    public PostDto findByTitle(String title){
        return PostMapper.INSTANCE.entityToDto(postRepository.findByTitle(title).get());
    }

    public List<PostDto> findByKeywordsContaining(String keyword, int page, int amount){
        Pageable pageable = PageRequest.of(page, amount);
        return PostMapper.INSTANCE.entityToDto(postRepository.findByKeywordsContaining(keyword, pageable));
    }

    public List<PostDto> findByLikesGreaterThanEqualAndDislikesGreaterThanEqual(int likes, int dislikes){
        return PostMapper.INSTANCE.entityToDto(postRepository.findByLikesGreaterThanEqualAndDislikesGreaterThanEqual(likes, dislikes));
    }
}
