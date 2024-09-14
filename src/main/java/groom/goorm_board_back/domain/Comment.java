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

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder
    public Comment(Long id,String comment,Board board) {
        this.id = id;
        this.comment = comment;
        this.board = board;
    }

    public static Comment createComment(String comment, Board board) {
        return Comment.builder()
                .comment(comment)
                .board(board)
                .build();
    }

    public void updateComment(String comment) {
        this.comment = comment;
    }
}