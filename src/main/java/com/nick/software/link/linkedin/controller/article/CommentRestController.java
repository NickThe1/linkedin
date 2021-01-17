package com.nick.software.link.linkedin.controller.article;

import com.nick.software.link.linkedin.persistence.DTO.article.CommentDto;
import com.nick.software.link.linkedin.service.article.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0.1/")
public class CommentRestController {

    private CommentService commentService;

    @Autowired
    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("user/comment")
    public ResponseEntity<?> createComment(CommentDto commentDto){
        commentService.createComment(commentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("user/comment/find/username/{username}")
    public ResponseEntity<List<CommentDto>> findByUsername(@PathVariable String username){
        return new ResponseEntity<>(commentService.findByAccount(username),HttpStatus.OK);
    }

    @GetMapping("user/comment/find/content/{body}")
    public ResponseEntity<List<CommentDto>> findByBodyContaining(@PathVariable String body){
        return new ResponseEntity<>(commentService.findByBodyContaining(body), HttpStatus.OK);
    }

    @GetMapping("user/comment/find/post/{post_id}")
    public ResponseEntity<List<CommentDto>> findByPost(@PathVariable long postId){
        return new ResponseEntity<>(commentService.findByPost(postId), HttpStatus.OK);
    }
}
