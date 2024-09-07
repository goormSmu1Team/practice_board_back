package groom.goorm_board_back.dto.comment;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class CommentSaveRequestDto {
    //댓글 RequestDto

    private String comment;
    private Board board;

    // Board 엔티티를 받아 Comment 엔티티로 변환
    public Comment toEntity(Board board) {
    return Comment.builder()
            .comment(comment)
            .board(board)
            .build();
}// 클라이언트에게 받아왔고 계층간 이동에 사용되는 dto를 DB에 접근할수있는 entity로 변환 용도

}
