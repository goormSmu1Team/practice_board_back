package groom.goorm_board_back.global.exception;

import groom.goorm_board_back.global.exception.board.BoardForbiddenException;
import groom.goorm_board_back.global.exception.board.BoardNotFoundException;
import groom.goorm_board_back.global.exception.comment.CommentForbiddenException;
import groom.goorm_board_back.global.exception.comment.CommentNotFoundException;
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


    //HTTP 403 FORBIDDEN
    @ExceptionHandler(BoardForbiddenException.class)
    public ResponseTemplate<ErrorResponse> boardForbidden(BoardForbiddenException e) {
        return new ResponseTemplate<>(HttpStatus.FORBIDDEN, ErrorCode.BOARD_FORBIDDEN.getMessage());
    }

    @ExceptionHandler(CommentForbiddenException.class)
    public ResponseTemplate<ErrorResponse> commentForbidden(CommentForbiddenException e) {
        return new ResponseTemplate<>(HttpStatus.FORBIDDEN, ErrorCode.COMMENT_FORBIDDEN.getMessage());
    }

    //HTTP 404 NOT_FOUND
    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseTemplate<ErrorResponse> memberNotFound(MemberNotFoundException e) {
        return new ResponseTemplate<>(HttpStatus.NOT_FOUND, ErrorCode.MEMBER_NOT_FOUND.getMessage());
    }

    @ExceptionHandler(BoardNotFoundException.class)
    public ResponseTemplate<ErrorResponse> boardNotFound(BoardNotFoundException e) {
        return new ResponseTemplate<>(HttpStatus.NOT_FOUND, ErrorCode.BOARD_NOT_FOUND.getMessage());
    }

    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseTemplate<ErrorResponse> commentNotFound(CommentNotFoundException e) {
        return new ResponseTemplate<>(HttpStatus.NOT_FOUND, ErrorCode.COMMENT_NOT_FOUND.getMessage());
    }

    //HTTP 409 CONFLICT
    @ExceptionHandler(MemberConflictException.class)
    public ResponseTemplate<ErrorResponse> memberConflictException(MemberConflictException e) {
        return new ResponseTemplate<>(HttpStatus.CONFLICT, ErrorCode.EMAIL_CONFLICT.getMessage());
    }
}
