package groom.goorm_board_back.service;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.domain.Comment;
import groom.goorm_board_back.dto.comment.CommentSaveRequestDto;
import groom.goorm_board_back.dto.comment.CommentSaveResponseDto;
import groom.goorm_board_back.repository.BoardRepository;
import groom.goorm_board_back.repository.CommentRepository;
import groom.goorm_board_back.response.ResponseData;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto addComment(Long boardId, CommentSaveRequestDto commentSaveRequestDto) {
        Board board = getBoardById(boardId);
        Comment comment = Comment.createComment(commentSaveRequestDto.comment(),board);
        Comment addComment = commentRepository.save(comment);

        return ResponseData.CommentResponseEntity(addComment);
    }

    public List<CommentSaveResponseDto> getCommentsByBoardDto(Long boardId) {
        List<Comment> comments = commentRepository.findByBoardId(boardId);

        if (comments.isEmpty()) {
            throw new IllegalArgumentException("댓글을 찾을 수 없습니다");
        }

        return comments.stream()
                .map(ResponseData::CommentResponseEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long boardId, Long commentId) {
        Comment comment = getCommentByBoardAndCommentId(boardId, commentId);
        commentRepository.delete(comment);
    }


    public CommentSaveResponseDto updateComment(Long boardId, Long commentId, CommentSaveRequestDto commentSaveRequestDto) {
        Comment comment = getCommentByBoardAndCommentId(boardId, commentId);
        comment.updateComment(commentSaveRequestDto.comment());

        return ResponseData.CommentResponseEntity(comment);
    }


    private Board getBoardById(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾지 못했습니다"));
    }

    private Comment getCommentByBoardAndCommentId(Long boardId, Long commentId) {
        return commentRepository.findByBoardIdAndId(boardId, commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글을 찾지 못했습니다"));
    }
}
