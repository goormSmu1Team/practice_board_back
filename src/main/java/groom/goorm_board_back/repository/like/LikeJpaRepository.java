package groom.goorm_board_back.repository.like;

import groom.goorm_board_back.domain.Member;
import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeJpaRepository extends JpaRepository<Like, Long> {

    boolean existsByWriterAndBoard(Member writer, Board board);

    void deleteByWriterAndBoard(Member writer, Board board);
}
