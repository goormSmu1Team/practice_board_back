package groom.goorm_board_back.dto.board;

import jakarta.validation.constraints.NotBlank;


public record BoardSaveRequestDto(
        @NotBlank(message = "제목을 입력하세요")
        String title,
        @NotBlank(message = "내용을 입력하세요")
        String content
) {}
