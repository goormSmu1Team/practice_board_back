package groom.goorm_board_back.controller;

import groom.goorm_board_back.dto.board.BoardSaveRequestDto;
import groom.goorm_board_back.dto.board.BoardSaveResponseDto;
import groom.goorm_board_back.dto.board.BoardUpdateRequestDto;
import groom.goorm_board_back.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Board")
@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @Operation(summary = "새 게시판 생성")
    @PostMapping
    public ResponseEntity<BoardSaveResponseDto> addBoard(@RequestBody @Valid BoardSaveRequestDto boardSaveRequestDto) {
        BoardSaveResponseDto responseDto = new BoardSaveResponseDto(boardService.save(boardSaveRequestDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @Operation(summary = "단일 게시판 조회")
    @GetMapping("/{id}")
    public ResponseEntity<BoardSaveResponseDto> findBoard(@PathVariable Long id){
        BoardSaveResponseDto responseDto = new BoardSaveResponseDto(boardService.findBoardId(id));

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "게시판 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "게시판 수정")
    @PutMapping("/{id}")
    public ResponseEntity<BoardSaveResponseDto> updateBoard(@PathVariable Long id,
                                                            @RequestBody @Valid BoardUpdateRequestDto boardUpdateRequestDto) {
        BoardSaveResponseDto responseDto = new BoardSaveResponseDto(boardService.updateBoard(id, boardUpdateRequestDto));

        return ResponseEntity.ok().body(responseDto);
    }
}