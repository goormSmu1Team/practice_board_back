package groom.goorm_board_back.service;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.domain.Comment;
import groom.goorm_board_back.dto.comment.CommentSaveRequestDto;
import groom.goorm_board_back.repository.BoardRepository;
import groom.goorm_board_back.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public long commentSave(long boarId,CommentSaveRequestDto commentSaveRequestDto) {
        Board board = boardRepository.findById(boarId).orElseThrow(() ->
                new IllegalArgumentException("게시글을 찾지 못했습니다"));

        Comment comment = commentSaveRequestDto.toEntity(board);
        Comment savedComment = commentRepository.save(comment);

        return savedComment.getId();
    }//댓글 추가

    @Transactional
    public void updateComment(long boardId, long id, CommentSaveRequestDto commentSaveRequestDto)
    {        Comment comment = commentRepository.findByBoardIdAndId(boardId, id).
             orElseThrow(() -> new IllegalArgumentException("댓글을 찾지 못했습니다"));

        comment.updateComment(commentSaveRequestDto.getComment());
        commentRepository.save(comment);
    }//댓글 수정


    public void delete(Long boardId, Long id) {
        Comment comment = commentRepository.findByBoardIdAndId(boardId, id).
                orElseThrow(() -> new IllegalArgumentException("댓글을 찾지 못했습니다"));

        commentRepository.delete(comment);
    }//댓글 삭제
}
