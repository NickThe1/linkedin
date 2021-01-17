package com.nick.software.link.linkedin.service.article;

import com.nick.software.link.linkedin.persistence.DTO.AccountDto;
import com.nick.software.link.linkedin.persistence.DTO.article.CommentDto;
import com.nick.software.link.linkedin.persistence.entity.Account;
import com.nick.software.link.linkedin.persistence.entity.article.Comment;
import com.nick.software.link.linkedin.persistence.entity.article.Post;
import com.nick.software.link.linkedin.persistence.mapping.CommentMapper;
import com.nick.software.link.linkedin.persistence.repository.AccountRepository;
import com.nick.software.link.linkedin.persistence.repository.CommentRepository;
import com.nick.software.link.linkedin.persistence.repository.PostRepository;
import com.nick.software.link.linkedin.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommentService {

    private CommentRepository commentRepository;
    private AccountRepository accountRepository;
    private PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, AccountRepository accountRepository,PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.accountRepository = accountRepository;
        this.postRepository = postRepository;
    }

    public void createComment(CommentDto commentDto){
        Comment comment = CommentMapper.INSTANCE.dtoToEntity(commentDto);
        commentRepository.save(comment);
    }

    public List<CommentDto> findByAccount(String username){
        Account account = accountRepository.findByUsername(username).get();
        return CommentMapper.INSTANCE.entityToDto(commentRepository.findByAccount(account));
    }

    public List<CommentDto> findByBodyContaining(String body){
        return CommentMapper.INSTANCE.entityToDto(commentRepository.findByBodyContaining(body));
    }

    public List<CommentDto> findByPost(long id){
        Post post = postRepository.findById(id).get();
        return CommentMapper.INSTANCE.entityToDto(commentRepository.findByPost(post));
    }
}
