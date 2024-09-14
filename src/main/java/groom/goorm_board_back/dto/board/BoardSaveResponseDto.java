package groom.goorm_board_back.dto.board;

import groom.goorm_board_back.domain.Board;

import java.time.LocalDateTime;

public record BoardSaveResponseDto(
        Long id,
        String title,
        String content,
        LocalDateTime createdDate,
        int viewCount
) {
    public BoardSaveResponseDto(Board board) {
        this(board.getId(), board.getTitle(), board.getContent(), board.getCreatedDate(), board.getViewCount());
    }
}