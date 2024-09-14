package groom.goorm_board_back.global.exception.board;

import groom.goorm_board_back.global.exception.dto.ErrorCode;
import lombok.Getter;

@Getter
public class BoardForbiddenException extends RuntimeException {

    private final ErrorCode errorCode;

    public BoardForbiddenException() {
        this.errorCode = ErrorCode.BOARD_FORBIDDEN;
    }
}
