package groom.goorm_board_back.global.exception.member;

import groom.goorm_board_back.global.exception.dto.ErrorCode;
import lombok.Getter;

@Getter
// 기본 생성자 추가
public class MemberNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public MemberNotFoundException() {
        this.errorCode = ErrorCode.MEMBER_NOT_FOUND;
    }
}

