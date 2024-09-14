package groom.goorm_board_back.repository.board;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.global.exception.ControllerAdvice;
import groom.goorm_board_back.global.exception.board.BoardNotFoundException;
import groom.goorm_board_back.global.exception.dto.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BoardRepository {

    private final BoardJpaRepository boardJpaRepository;
    private final ControllerAdvice controllerAdvice;

    public void save(Board board) {
        boardJpaRepository.save(board);
    }

    public void delete(Board board) {
        boardJpaRepository.delete(board);
    }

    public Board findByBoardWithId(Long boardId) {
        return boardJpaRepository.findById(boardId).orElseThrow(BoardNotFoundException::new);
    }
}
