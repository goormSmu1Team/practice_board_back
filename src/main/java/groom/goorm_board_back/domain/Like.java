package groom.goorm_board_back.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member writer;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder
    public Like(Member writer, Board board) {
        this.writer = writer;
        this.board = board;
    }
}
