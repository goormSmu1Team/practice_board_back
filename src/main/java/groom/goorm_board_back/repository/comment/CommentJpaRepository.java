package groom.goorm_board_back.repository.comment;

import groom.goorm_board_back.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJpaRepository extends JpaRepository<Comment, Long> {
}
