package groom.goorm_board_back.response;


import groom.goorm_board_back.domain.Comment;
import groom.goorm_board_back.dto.comment.CommentSaveResponseDto;

public class ResponseData {
    public static CommentSaveResponseDto CommentResponseEntity(Comment comment) {
        return CommentSaveResponseDto.builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .build();
    }
}
