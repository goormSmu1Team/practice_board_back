package groom.goorm_board_back.dto.comment;

import jakarta.validation.constraints.NotBlank;


public record CommentSaveRequestDto(
        @NotBlank(message = "댓글을 입력하세요")
        String comment
) {}
