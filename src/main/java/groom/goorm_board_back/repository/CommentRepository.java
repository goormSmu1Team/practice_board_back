package groom.goorm_board_back.repository;

import groom.goorm_board_back.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByBoardIdAndId(Long boardId, Long commentId);
    List<Comment> findByBoardId(Long boardId); // 게시글 ID로 댓글 리스트 조회
    void deleteAllByBoardId(Long boardId);
}