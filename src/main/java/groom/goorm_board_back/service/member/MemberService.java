package groom.goorm_board_back.service.member;

import groom.goorm_board_back.domain.Member;
import groom.goorm_board_back.domain.Role;
import groom.goorm_board_back.dto.jwt.JwtDto;
import groom.goorm_board_back.dto.member.MemberSignUpDto;
import groom.goorm_board_back.global.exception.dto.ErrorCode;
import groom.goorm_board_back.global.exception.member.MemberConflictException;
import groom.goorm_board_back.global.jwt.JwtProvider;
import groom.goorm_board_back.repository.member.MemberJpaRepository;
import groom.goorm_board_back.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService customUserDetailsService;

    public void signUp(MemberSignUpDto memberSignUptDto) throws MemberConflictException {
        if (memberJpaRepository.existsByEmail(memberSignUptDto.email())) {
            throw new MemberConflictException(ErrorCode.EMAIL_CONFLICT);
        }

        if (memberJpaRepository.existsByUsername(memberSignUptDto.username())) {
            throw new MemberConflictException(ErrorCode.USERNAME_CONFLICT);
        }

        Member member = Member.builder()
                .email(memberSignUptDto.email())
                .password(passwordEncoder.encode(memberSignUptDto.password()))
                .username(memberSignUptDto.username())
                .role(Role.ROLE_USER)
                .build();
        memberJpaRepository.save(member);
    }

    @Transactional
    public JwtDto signIn(MemberSignUpDto memberSignUpDto) {

        UsernamePasswordAuthenticationToken authenticationToken = customUserDetailsService.toAuthentication(memberSignUpDto.email(), memberSignUpDto.password());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        return jwtProvider.generateToken(authentication);
    }
}
