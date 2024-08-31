package groom.goorm_board_back.service;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.dto.BoardSaveRequestDto;
import groom.goorm_board_back.dto.BoardUpdateRequestDto;
import groom.goorm_board_back.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    //게시글 추가
    public Board save(BoardSaveRequestDto saveDto) {
        return boardRepository.save(saveDto.toEntity());
    }

    //게시글 조회
    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    //게시글 삭제
    public void delete(long id){
        boardRepository.deleteById(id);
    }

    //게시글 수정
    @Transactional
    public Board update(long id , BoardUpdateRequestDto updateDto){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾지 못했다람쥐"));

        board.updateTitle(updateDto.getTitle());
        board.updateContent(updateDto.getContent());
        return board;
    }


}
