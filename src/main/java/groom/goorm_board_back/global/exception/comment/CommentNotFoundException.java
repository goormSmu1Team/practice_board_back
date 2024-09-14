package groom.goorm_board_back.global.exception.comment;

import groom.goorm_board_back.global.exception.dto.ErrorCode;
import lombok.Getter;

@Getter
public class CommentNotFoundException extends RuntimeException {

    private final ErrorCode errorCode;

    public CommentNotFoundException() {
        this.errorCode = ErrorCode.COMMENT_NOT_FOUND;
    }
}
