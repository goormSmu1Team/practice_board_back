package groom.goorm_board_back.global.exception;

import groom.goorm_board_back.global.exception.dto.ErrorCode;
import groom.goorm_board_back.global.exception.dto.ErrorResponse;
import groom.goorm_board_back.global.exception.member.EmailConflictException;
import groom.goorm_board_back.global.exception.member.MemberConflictException;
import groom.goorm_board_back.global.exception.member.MemberNotFoundException;
import groom.goorm_board_back.global.exception.member.UsernameConflictException;
import groom.goorm_board_back.global.template.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    //HTTP 404 NOT_FOUND
    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseTemplate<ErrorResponse> memberNotFound(MemberNotFoundException e) {
        return new ResponseTemplate<>(HttpStatus.NOT_FOUND, e.getMessage());
    }

    //HTTP 409 CONFLICT
    @ExceptionHandler(MemberConflictException.class)
    public ResponseTemplate<ErrorResponse> memberConflictException(MemberConflictException e) {
        return new ResponseTemplate<>(HttpStatus.CONFLICT, e.getMessage());
    }
}
