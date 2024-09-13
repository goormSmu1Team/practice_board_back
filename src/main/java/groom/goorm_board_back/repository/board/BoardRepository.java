package groom.goorm_board_back.repository.board;

import groom.goorm_board_back.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BoardRepository {

    private final BoardJpaRepository boardJpaRepository;

    public void save(Board board) {
        boardJpaRepository.save(board);
    }

    public void delete(Board board) {
        boardJpaRepository.delete(board);
    }

    public Board findByBoardWithId(Long boardId) {
        return boardJpaRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
    }
}
