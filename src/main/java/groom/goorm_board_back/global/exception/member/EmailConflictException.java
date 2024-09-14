package groom.goorm_board_back.global.exception.member;

import groom.goorm_board_back.global.exception.dto.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class EmailConflictException extends MemberConflictException{

    public EmailConflictException(ErrorCode errorCode) {
        super(errorCode);
    }
}
