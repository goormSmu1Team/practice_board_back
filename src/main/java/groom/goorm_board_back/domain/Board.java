package groom.goorm_board_back.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// Private로 하면 프록시 객체 생성에 문제 생김, Public으로 하면 무분별 객체 생성,setter를 통한 값 주입을 해 Protected로 결정

@Table(name = "board")
@Entity
public class Board {
    //게시판 엔티티

    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;
    //제목

    @Column(name = "content", nullable = false)
    private String content;
    //내용

    @Column(name = "view_count")
    private Integer viewCount;
    //조회수

    @Column(name = "like_count")
    private Integer likeCount = 0;
    //좋아요

    @Column(name = "created_date")
    private LocalDateTime createdDate;
    //생성날짜

    @OneToMany(mappedBy = "board", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})//게시판이 삭제되면 댓글도 같이 삭제됨
    private List<Comment> comments;
    //댓글

    @Builder // 안정성 보장을 위해 빌더 패턴
    public Board(long id ,String title, String content,int viewCount,int likeCount) {
        //게시글 사용 용도
        this.id = id;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.createdDate = LocalDateTime.now();
    }


    public void updateTitle(String title) {
        this.title = title;
    } // 게시글(제목) 수정 용도
    public void updateContent(String content) {
        this.content = content;
    } // 게시글(내용) 수정 용도

    public void updateViewCount() {
        if (this.viewCount == null) {
            this.viewCount = 0;
        }
        this.viewCount += 1;
    } // 조회수 증가

    public void incrementLikeCount() {
        if (this.likeCount == null) {
            this.likeCount = 0; // null일 경우 0으로 초기화
        }
        this.likeCount += 1;
    }

    public void decrementLikeCount() {
        if (this.likeCount == null) {
            this.likeCount = 0; // null일 경우 0으로 초기화
        }
        if (this.likeCount > 0) {
            this.likeCount -= 1;
        }
    }
}

