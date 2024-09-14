package groom.goorm_board_back.repository.member;

import groom.goorm_board_back.global.exception.member.MemberNotFoundException;
import groom.goorm_board_back.global.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import groom.goorm_board_back.domain.Member;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    public Member findByMemberWithId() {
        return memberJpaRepository.findById(SecurityUtil.getCurrentUsername()).orElseThrow(MemberNotFoundException::new);
    }
}
