package groom.goorm_board_back.service;

import groom.goorm_board_back.domain.User;
import groom.goorm_board_back.dto.UserLoginRequestDto;
import groom.goorm_board_back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(UserLoginRequestDto userLoginRequestDto) {
        userRepository.findByLoginId(userLoginRequestDto.getLoginId())
                .ifPresent(user -> {
                    throw new IllegalArgumentException("아이디 다른 값으로");
                });

        User user = User.builder()
                .loginId(userLoginRequestDto.getLoginId())
                .password(bCryptPasswordEncoder.encode(userLoginRequestDto.getPassword())) // 비밀번호 암호화
                .build();

        return userRepository.save(user).getId();
    }
}