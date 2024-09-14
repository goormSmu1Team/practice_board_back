package groom.goorm_board_back.service;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.dto.board.BoardSaveRequestDto;
import groom.goorm_board_back.dto.board.BoardUpdateRequestDto;
import groom.goorm_board_back.repository.BoardRepository;
import groom.goorm_board_back.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Board save(BoardSaveRequestDto boardSaveRequestDto) {
        Board board = Board.createBoard(
                boardSaveRequestDto.title(),
                boardSaveRequestDto.content()
        );

        return boardRepository.save(board);
    }

    @Transactional()
    public Board findBoardId(Long id) {
        Board board = getBoardById(id);

        board.updateViewCount();
        boardRepository.save(board);

        return board;
    }

    @Transactional
    public void delete(Long id) {
        Board board = getBoardById(id);

        commentRepository.deleteAllByBoardId(id);

        boardRepository.delete(board);
    }

    public Board updateBoard(Long id , BoardUpdateRequestDto boardUpdateRequestDto){
        Board board = getBoardById(id);

        board.updateTitle(boardUpdateRequestDto.title());
        board.updateContent(boardUpdateRequestDto.content());

        return board;
    }

    private Board getBoardById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾지 못했습니다"));
    }
}





