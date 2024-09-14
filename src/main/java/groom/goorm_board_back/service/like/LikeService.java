package groom.goorm_board_back.service.like;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.domain.Like;
import groom.goorm_board_back.domain.Member;
import groom.goorm_board_back.repository.board.BoardRepository;
import groom.goorm_board_back.repository.like.LikeJpaRepository;
import groom.goorm_board_back.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final LikeJpaRepository likeJpaRepository;

    @Transactional
    public void addLike(Long boardId ) {
        Board board = boardRepository.findByBoardWithId(boardId);
        Member writer = memberRepository.findByMemberWithId();
        if(!likeJpaRepository.existsByWriterAndBoard(writer, board)) {
            board.incrementLikeCount();
            likeJpaRepository.save(new Like(writer, board));
        } else {
            board.decrementLikeCount();
            likeJpaRepository.deleteByWriterAndBoard(writer, board);
        }
    }
}
