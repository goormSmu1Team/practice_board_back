package groom.goorm_board_back.controller;


import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.dto.BoardSaveRequestDto;
import groom.goorm_board_back.dto.BoardSaveResponseDto;
import groom.goorm_board_back.dto.BoardUpdateRequestDto;
import groom.goorm_board_back.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<Board> addBoard(@RequestBody BoardSaveRequestDto boardSaveRequestDto) {
        Board saveBoard = boardService.save(boardSaveRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(saveBoard);
    }//추가

    @GetMapping("/board")
    public ResponseEntity<List<BoardSaveResponseDto>> findAllBoard(){
        List<BoardSaveResponseDto> board = boardService.findAll()
                .stream()
                .map(BoardSaveResponseDto::new)
                .toList();

        return ResponseEntity.ok().
                body(board);
    }//조회

    @DeleteMapping("/board/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable long id) {
        boardService.delete(id);

        return ResponseEntity.ok()
                .build();
    }//삭제

    @PutMapping("/board/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable long id,
           @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        Board board = boardService.update(id, boardUpdateRequestDto);

        return ResponseEntity.ok()
                        .body(board);

    }//수정
}
