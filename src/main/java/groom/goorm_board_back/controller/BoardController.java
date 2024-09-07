package groom.goorm_board_back.controller;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.dto.board.BoardSaveRequestDto;
import groom.goorm_board_back.dto.board.BoardSaveResponseDto;
import groom.goorm_board_back.dto.board.BoardUpdateRequestDto;
import groom.goorm_board_back.service.BoardService;
import groom.goorm_board_back.service.LikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import groom.goorm_board_back.repository.BoardRepository;
import java.util.List;

@Tag(name = "Board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final LikeService likeService;

    @Operation(summary = "새 게시판 생성")
    @PostMapping("/board")
    public ResponseEntity<Board> addBoard(@RequestBody @Validated BoardSaveRequestDto boardSaveRequestDto) {
        Board saveBoard = boardService.save(boardSaveRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(saveBoard);
    }//게시판 추가


    @Operation(summary = "전체 게시판 조회")
    @GetMapping("/board")
    public ResponseEntity<List<BoardSaveResponseDto>> findAllBoard(){

        List<Board> findBoard = boardService.findAll();

        for (int i = 0; i < findBoard.size(); i++) {
            Board board = findBoard.get(i);
            board.updateViewCount();  //전체 게시판 조회할때마다 증가시킴
            boardRepository.save(board);
        }

        List<BoardSaveResponseDto> board = boardService.findAll()
                .stream()
                .map(BoardSaveResponseDto::new)
                .toList();

        return ResponseEntity.ok().
                body(board);
    }//게시판 조회

    @Operation(summary = "게시판 삭제")
    @DeleteMapping("/board/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable long id) {
        boardService.delete(id);

        return ResponseEntity.ok()
                .build();
    }//게시판 삭제

    @Operation(summary = "게시판 수정")
    @PutMapping("/board/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable long id,
           @RequestBody @Validated BoardUpdateRequestDto boardUpdateRequestDto) {
        Board updateBoard = boardService.updateBoard(id, boardUpdateRequestDto);

        return ResponseEntity.ok()
                        .body(updateBoard);

    }//게시판 수정

    @PostMapping("/board/{boardId}/like")
    public ResponseEntity addLike(@PathVariable("boardId")Long boardId) {

        likeService.addLike(boardId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }//좋아요 기능

}
