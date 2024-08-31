package groom.goorm_board_back.dto;

import groom.goorm_board_back.domain.Board;
import lombok.Getter;

@Getter
public class BoardSaveResponseDto {
    private final String title;
    private final String content;

    public BoardSaveResponseDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
    } // DB에서 repository를 통해 조회하거나 가져온 entity(도메인)를 dto로 변환 용도
}
