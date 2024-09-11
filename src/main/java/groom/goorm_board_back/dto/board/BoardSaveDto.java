package groom.goorm_board_back.dto.board;

import groom.goorm_board_back.domain.Board;
import jakarta.validation.constraints.NotBlank;


public record BoardSaveDto(
        @NotBlank(message = "제목을 입력해주세요.") String title,
        @NotBlank(message = "내용을 입력해주세요.") String content) {

}
