package groom.goorm_board_back.service.comment;

import groom.goorm_board_back.domain.Comment;
import groom.goorm_board_back.dto.comment.CommentInfoDto;
import groom.goorm_board_back.dto.comment.CommentSaveDto;
import groom.goorm_board_back.dto.comment.CommentUpdateDto;
import groom.goorm_board_back.global.exception.comment.CommentForbiddenException;
import groom.goorm_board_back.global.util.SecurityUtil;
import groom.goorm_board_back.repository.board.BoardRepository;
import groom.goorm_board_back.repository.comment.CommentJpaRepository;
import groom.goorm_board_back.repository.comment.CommentRepository;
import groom.goorm_board_back.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final CommentJpaRepository commentJpaRepository;

    public void save(Long boardId, CommentSaveDto commentSaveDto) {

        Comment comment = Comment.builder()
                .content(commentSaveDto.content())
                .writer(memberRepository.findByMemberWithId())
                .board(boardRepository.findByBoardWithId(boardId))
                .build();
        commentRepository.save(comment);
    }

    @Transactional
    public void update(Long id, CommentUpdateDto commentUpdateDto) {

        Comment comment = commentRepository.findByCommentWithId(id);
        checkAuthority(comment);
        comment.updateContent(commentUpdateDto.content());
    }

    public void delete(Long id) {

        Comment comment = commentRepository.findByCommentWithId(id);
        checkAuthority(comment);
        commentRepository.delete(comment);
    }

    private void checkAuthority(Comment comment) throws CommentForbiddenException {
        if(!comment.getWriter().equals(memberRepository.findByMemberWithId())) {
            throw new CommentForbiddenException();
        }
    }

    public List<CommentInfoDto> getComments(Long boardId) {
        return commentJpaRepository.findByBoardId(boardId).stream()
                .map(CommentInfoDto::new)
                .collect(Collectors.toList());
    }
}
