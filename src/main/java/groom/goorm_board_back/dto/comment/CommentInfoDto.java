package groom.goorm_board_back.dto.comment;

import groom.goorm_board_back.domain.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

public record CommentInfoDto(
        Long boardId,
        Long commentId,
        String username,
        String content,
        LocalDateTime createdAt
) {
    public CommentInfoDto(Comment comment) {
        this(
                comment.getBoard().getId(),
                comment.getId(),
                comment.getWriter().getUsername(),
                comment.getContent(),
                comment.getCreatedAt()
        );
    }
}
