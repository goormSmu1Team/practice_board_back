package groom.goorm_board_back.service;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.domain.Like;
import groom.goorm_board_back.repository.BoardRepository;
import groom.goorm_board_back.repository.LikeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final BoardRepository boardRepository;
    private final LikeRepository likeRepository;

    @Transactional
    public void addLike(long boardId) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾지 못했습니다"));

        if (!likeRepository.existsByBoard(board)) {
            // 좋아요가 없으면 추가하고 게시판의 좋아요 수 증가
            Like newLike = Like.builder()
                    .board(board)
                    .build();
            likeRepository.save(newLike);
            board.incrementLikeCount(); // 좋아요 수 증가
        } else {
            // 이미 좋아요가 눌렸다면 좋아요 취소 (좋아요 수 감소)
            Like existingLike = likeRepository.findByBoard(board);
            likeRepository.delete(existingLike); // 기존 Like 삭제
            board.decrementLikeCount(); // 좋아요 수 감소
        }
    }
}