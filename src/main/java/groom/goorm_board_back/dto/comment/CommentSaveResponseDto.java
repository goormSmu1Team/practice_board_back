package groom.goorm_board_back.dto.comment;

import groom.goorm_board_back.domain.Comment;
import lombok.Getter;


@Getter
public class CommentSaveResponseDto {
    //댓글 ResponseDto
    private final long id;
    private final String comment;
    private final Long boardId;

    public CommentSaveResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.boardId = comment.getBoard().getId();
    } // DB에서 repository를 통해 조회하거나 가져온 entity(도메인)를 dto로 변환 용도
}
