package com.nick.software.link.linkedin.controller.article;

import com.nick.software.link.linkedin.persistence.DTO.article.PostDto;
import com.nick.software.link.linkedin.service.article.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0.1/")
public class PostRestController {

    private PostService postService;

    @Autowired
    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("post/create")
    public ResponseEntity<?> createPost(@RequestBody PostDto postDto){
        postService.createPost(postDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("post/find/{title}")
    public ResponseEntity<PostDto> findPostByTitle(@PathVariable String title){
        return new ResponseEntity<>(postService.findByTitle(title), HttpStatus.OK);
    }

    @GetMapping("post/find/keyword/{keyword}/{page}/{amount}")
    public ResponseEntity<List<PostDto>> findByKeywordsContaining(@PathVariable String keyword,
                                                                  @PathVariable int page,
                                                                  @PathVariable int amount){
        return new ResponseEntity<>(postService.findByKeywordsContaining(keyword, page, amount), HttpStatus.OK);
    }

    @GetMapping("post/find/sentiment/{likes}/{dislikes}")
    public ResponseEntity<List<PostDto>> findByLikesGreaterThanEqualAndDislikesGreaterThanEqual(@PathVariable int likes,
                                                                  @PathVariable int dislikes){
        return new ResponseEntity<>(postService.findByLikesGreaterThanEqualAndDislikesGreaterThanEqual(likes, dislikes), HttpStatus.OK);
    }
}
