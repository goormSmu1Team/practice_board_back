package groom.goorm_board_back.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import groom.goorm_board_back.domain.Member;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Member> findByUsername(String username);
    boolean existsByUsername(String username);
}
