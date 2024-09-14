package groom.goorm_board_back.controller;

import groom.goorm_board_back.dto.comment.CommentSaveRequestDto;
import groom.goorm_board_back.dto.comment.CommentSaveResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import groom.goorm_board_back.service.CommentService;

import java.util.List;

@Tag(name = "Comment")
@RequiredArgsConstructor
@RestController
@RequestMapping("/boards/{boardId}/comments")
public class CommentController {

    private final CommentService commentService;

    @Operation(summary = "새 댓글 추가")
    @PostMapping
    public ResponseEntity<CommentSaveResponseDto> addComment(@PathVariable Long boardId,
                                                             @RequestBody @Valid CommentSaveRequestDto commentSaveRequestDto) {
        CommentSaveResponseDto savedCommentDto = commentService.addComment(boardId, commentSaveRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCommentDto);
    }

    @Operation(summary = "게시판 조회")
    @GetMapping
    public ResponseEntity<List<CommentSaveResponseDto>> getCommentsByBoard(@PathVariable Long boardId) {
        List<CommentSaveResponseDto> comments = commentService.getCommentsByBoardDto(boardId);
        return ResponseEntity.ok(comments);
    }

    @Operation(summary = "댓글 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long boardId,@PathVariable Long id){
        commentService.delete(boardId, id);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "댓글 수정")
    @PutMapping("/{id}")
    public ResponseEntity<CommentSaveResponseDto> updateComment(@PathVariable Long boardId,@PathVariable Long id
            ,@RequestBody @Valid CommentSaveRequestDto commentSaveRequestDto){
        CommentSaveResponseDto updatedCommentDto = commentService.updateComment(boardId, id, commentSaveRequestDto);

        return ResponseEntity.ok().body(updatedCommentDto);
    }

}
