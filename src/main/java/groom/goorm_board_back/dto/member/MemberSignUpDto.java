package groom.goorm_board_back.dto.member;

import groom.goorm_board_back.domain.Role;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public record MemberSignUpDto(
        String email,
        String password,
        String username,
        Role role
) {
}

