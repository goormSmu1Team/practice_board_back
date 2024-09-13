package groom.goorm_board_back.repository.comment;

import groom.goorm_board_back.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CommentRepository {

    private final CommentJpaRepository commentJpaRepository;

    public void save(Comment comment) {
        commentJpaRepository.save(comment);
    }

    public void delete(Comment comment) {
        commentJpaRepository.delete(comment);
    }

    public Comment findByCommentWithId(Long commentId) {
        return commentJpaRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
    }
}
