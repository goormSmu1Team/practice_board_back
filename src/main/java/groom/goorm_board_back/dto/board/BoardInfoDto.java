package groom.goorm_board_back.dto.board;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.domain.Comment;
import groom.goorm_board_back.dto.comment.CommentInfoDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record BoardInfoDto(
        Long boardId,
        String username,
        String title,
        String content,
        int views,
        LocalDateTime createdAt
) {
    public static BoardInfoDto from(Board board) {
        return new BoardInfoDto(
                board.getId(),
                board.getWriter().getUsername(),
                board.getTitle(),
                board.getContent(),
                board.getViews(),
                board.getCreatedAt()
        );
    }
}
