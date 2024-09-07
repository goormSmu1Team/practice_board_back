package groom.goorm_board_back.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

@Table(name="likes")
@Entity
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long likeid;


    //연관관계 Board랑 매핑
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder
    public Like(Board board) {
        this.board = board;
    }
}
