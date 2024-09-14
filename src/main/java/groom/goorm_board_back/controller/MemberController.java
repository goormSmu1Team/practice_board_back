package groom.goorm_board_back.controller;

import groom.goorm_board_back.dto.jwt.JwtDto;
import groom.goorm_board_back.global.exception.member.EmailConflictException;
import groom.goorm_board_back.global.exception.member.UsernameConflictException;
import groom.goorm_board_back.global.template.ResponseTemplate;
import groom.goorm_board_back.dto.member.MemberSignUpDto;
import groom.goorm_board_back.service.member.MemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/signUp")
    public ResponseTemplate<?> signUp(@RequestBody MemberSignUpDto memberSignUpDto) {
        memberService.signUp(memberSignUpDto);
        return new ResponseTemplate<>(HttpStatus.CREATED, "회원가입 성공");
    }

    @PostMapping("/member/signIn")
    public ResponseTemplate<JwtDto> signIn(@RequestBody MemberSignUpDto memberRequestDto) {
        return new ResponseTemplate<JwtDto>(HttpStatus.OK, "로그인 성공", memberService.signIn(memberRequestDto));
    }
}
