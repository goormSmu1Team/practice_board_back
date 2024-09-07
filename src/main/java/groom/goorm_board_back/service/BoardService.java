package groom.goorm_board_back.service;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.dto.board.BoardSaveRequestDto;
import groom.goorm_board_back.dto.board.BoardUpdateRequestDto;
import groom.goorm_board_back.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board save(BoardSaveRequestDto boardSaveRequestDto) {
        return boardRepository.save(boardSaveRequestDto.toEntity());
    }//게시글 추가

    @Transactional
    public List<Board> findAll(){
        return boardRepository.findAll();
    }//게시글 조회

    public void delete(long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾지 못했습니다"));

        boardRepository.delete(board);
    }//게시글 삭제

    @Transactional
    public Board updateBoard(long id , BoardUpdateRequestDto boardUpdateRequestDto){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾지 못했습니다"));

        board.updateTitle(boardUpdateRequestDto.getTitle());
        board.updateContent(boardUpdateRequestDto.getContent());
        return board;
    }//게시글 수정

}
