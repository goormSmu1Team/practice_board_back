package groom.goorm_board_back.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class Post {

    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

//    @Column(name = "view_count")
//    private int viewCount = 0;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Builder // 안정성 보장을 위해 빌더 패턴
    public Post(String title, String content) {
        //이 빌더는 게시글 사용할때만 사용할 용도
        this.title = title;
        this.content = content;
        this.createdDate = LocalDateTime.now();
    }


    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }

}
