package groom.goorm_board_back.dto.board;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BoardUpdateDto(
        @NotNull(message = "제목을 입력해주세요.") String title,
        @NotNull(message = "내용을 입력해주세요.") String content) {

}
