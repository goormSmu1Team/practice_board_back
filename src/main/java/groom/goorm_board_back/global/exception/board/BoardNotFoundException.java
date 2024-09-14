package groom.goorm_board_back.global.exception.board;

import groom.goorm_board_back.global.exception.dto.ErrorCode;
import lombok.Getter;

@Getter
public class BoardNotFoundException extends RuntimeException {

    private final ErrorCode errorCode;

    public BoardNotFoundException() {
        this.errorCode = ErrorCode.BOARD_NOT_FOUND;
    }
}
