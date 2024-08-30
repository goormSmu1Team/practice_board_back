package groom.goorm_board_back.service;

import groom.goorm_board_back.domain.Post;
import groom.goorm_board_back.dto.PostDto;
import groom.goorm_board_back.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    //게시글 추가
    public Post save(PostDto postDto) {
        return postRepository.save(postDto.toEntity());
    }
}
