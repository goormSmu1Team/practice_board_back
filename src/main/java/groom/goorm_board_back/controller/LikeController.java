package groom.goorm_board_back.controller;

import groom.goorm_board_back.dto.like.LikeUpdateDto;
import groom.goorm_board_back.global.template.ResponseTemplate;
import groom.goorm_board_back.service.like.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/like/{boardId}")
    public ResponseTemplate<?> addLike(@PathVariable("boardId") Long boardId) {
        likeService.addLike(boardId);
        return new ResponseTemplate<>(HttpStatus.CREATED, "게시글 좋아요 구현 완료.");
    }
}
