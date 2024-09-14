package groom.goorm_board_back.dto.comment;

import lombok.Builder;

@Builder
public record CommentSaveResponseDto(
        Long id,
        String comment
) {}