package groom.goorm_board_back.service.comment;

import groom.goorm_board_back.domain.Comment;
import groom.goorm_board_back.dto.comment.CommentSaveDto;
import groom.goorm_board_back.dto.comment.CommentUpdateDto;
import groom.goorm_board_back.global.util.SecurityUtil;
import groom.goorm_board_back.repository.board.BoardRepository;
import groom.goorm_board_back.repository.comment.CommentRepository;
import groom.goorm_board_back.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public void save(Long boardId, CommentSaveDto commentSaveDto) {

        Comment comment = new Comment(commentSaveDto.content());
        memberRepository.findByMemberWithId();
        boardRepository.findByBoardWithId(boardId);
        commentRepository.save(comment);
    }

    public void update(Long id, CommentUpdateDto commentUpdateDto) {

        Comment comment = commentRepository.findByCommentWithId(id);
        checkAuthority(comment);
        commentUpdateDto.content().ifPresent(comment::updateContent);
        commentRepository.save(comment);
    }

    public void delete(Long id) {

        Comment comment = commentRepository.findByCommentWithId(id);
        checkAuthority(comment);
        commentRepository.delete(comment);
    }

    public void checkAuthority(Comment comment) {
        if(!comment.getMember().getId().equals(SecurityUtil.getCurrentUsername())) {
            throw new IllegalArgumentException("삭제 할 권한이 없습니다.");
        }
    }

//    public CommentInfoDto getCommentInfo(Long id) {
//        return new CommentInfoDto(commentRepository.findById(id).orElseThrow(IllegalArgumentException::new));
//    }

//    public List<CommentInfoDto> getComments(Long boardId) {
//
//        List<Comment> comment = commentRepository.findByBoardId(boardId);
//
//        return comment.stream().map(comment1 -> {
//            return new CommentInfoDto(comment);
//        }).collect(Collectors.toList());
//    }
}
