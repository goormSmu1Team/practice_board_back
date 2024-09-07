package groom.goorm_board_back.repository;

import groom.goorm_board_back.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
         Optional<Comment> findByBoardIdAndId(Long boardId, Long id);
}