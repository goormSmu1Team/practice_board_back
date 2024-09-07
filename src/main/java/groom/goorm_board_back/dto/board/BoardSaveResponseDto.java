package groom.goorm_board_back.dto.board;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.dto.comment.CommentSaveResponseDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class BoardSaveResponseDto {
    //게시판 ResponseDto
    private final long id;
    private final String title;
    private final String content;
    private final LocalDateTime createdDate;
    private final Integer viewCount;
    private final Integer likeCount;
    private final List<CommentSaveResponseDto> comments;

    public BoardSaveResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.createdDate = board.getCreatedDate();
        this.viewCount = board.getViewCount();
        this.likeCount = board.getLikeCount();
        this.comments = board.getComments()
                        .stream()
                        .map(CommentSaveResponseDto::new)
                        .collect(Collectors.toList());
    }
}
