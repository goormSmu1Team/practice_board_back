package groom.goorm_board_back.repository;

import groom.goorm_board_back.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLoginId(String loginId);
    // 주어진 아이디를 사용하여 회원을 조회하는 메서드
}
