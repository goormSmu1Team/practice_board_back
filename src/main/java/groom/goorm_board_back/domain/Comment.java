package groom.goorm_board_back.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

@Table(name="comments")
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;

    //연관관계 Board랑 매핑
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder // 안정성 보장을 위해 빌더 패턴
    public Comment(long id,String comment,Board board) {
        //댓글 사용 용도
        this.id = id;
        this.comment = comment;
        this.board = board;
    }

    public void updateComment(String comment) {
        this.comment = comment;
    }//댓글 수정용
}