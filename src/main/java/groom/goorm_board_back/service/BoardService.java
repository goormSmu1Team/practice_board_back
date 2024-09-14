package groom.goorm_board_back.service;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.dto.board.BoardSaveRequestDto;
import groom.goorm_board_back.dto.board.BoardSaveResponseDto;
import groom.goorm_board_back.dto.board.BoardUpdateRequestDto;
import groom.goorm_board_back.repository.BoardRepository;
import groom.goorm_board_back.repository.CommentRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    public Page<BoardSaveResponseDto> paging(Pageable pageable) {
        int page = pageable.getPageNumber();
        int pageLimit = 10;
        Page<Board> boardPages = boardRepository.
                findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.ASC, "id")));

        return boardPages.map(BoardSaveResponseDto::new);
    }

    private Board getBoardById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾지 못했습니다"));
    }
}





