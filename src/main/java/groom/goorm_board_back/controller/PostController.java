package groom.goorm_board_back.controller;


import groom.goorm_board_back.domain.Post;
import groom.goorm_board_back.dto.PostDto;
import groom.goorm_board_back.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<Post> addPost(@RequestBody PostDto postDto) {
        Post savePost = postService.save(postDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savePost);
    }
}
