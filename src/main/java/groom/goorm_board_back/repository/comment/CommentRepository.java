package groom.goorm_board_back.repository.comment;

import groom.goorm_board_back.domain.Comment;
import groom.goorm_board_back.global.exception.comment.CommentNotFoundException;
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
        return commentJpaRepository.findById(commentId).orElseThrow(CommentNotFoundException::new);
    }
}
