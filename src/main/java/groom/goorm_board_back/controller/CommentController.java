package groom.goorm_board_back.controller;

import groom.goorm_board_back.dto.comment.CommentSaveRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import groom.goorm_board_back.service.CommentService;

@Tag(name = "Comment")
@RequiredArgsConstructor
@RestController

public class CommentController {

    private final CommentService commentService;

    @Operation(summary = "새 댓글 추가")
    @PostMapping("/board/{boardId}/comment")
    public ResponseEntity addComment(@PathVariable long boardId,
                                    @RequestBody CommentSaveRequestDto commentSaveRequestDto) {

        long savedCommentId = commentService.commentSave(boardId, commentSaveRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCommentId);
    } // 댓글 추가


    @Operation(summary = "댓글 삭제")
    @DeleteMapping("/board/{boardId}/comment/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable long boardId,@PathVariable long id){
        commentService.delete(boardId, id);

        return ResponseEntity.ok()
                .build();
    } // 댓글 삭제

    @Operation(summary = "댓글 수정")
    @PutMapping ("/board/{boardId}/comment/{id}")
    public ResponseEntity<Long> updateComment(@PathVariable long boardId,@PathVariable long id
            ,@RequestBody CommentSaveRequestDto commentSaveRequestDto){
        commentService.updateComment(boardId,id,commentSaveRequestDto);

        return ResponseEntity.ok()
                .body(id);
    } // 댓글 수정

}
