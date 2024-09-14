package groom.goorm_board_back.global.exception.comment;

import groom.goorm_board_back.global.exception.dto.ErrorCode;
import lombok.Getter;

@Getter
public class CommentForbiddenException extends RuntimeException {

    private final ErrorCode errorCode;

    public CommentForbiddenException() {
        this.errorCode = ErrorCode.COMMENT_FORBIDDEN;
    }
}
