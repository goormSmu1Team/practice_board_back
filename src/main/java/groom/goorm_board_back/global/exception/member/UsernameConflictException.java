package groom.goorm_board_back.global.exception.member;

import groom.goorm_board_back.global.exception.dto.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UsernameConflictException extends MemberConflictException{

    public UsernameConflictException(ErrorCode errorCode) {
        super(errorCode);
    }
}
