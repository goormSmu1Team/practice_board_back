package groom.goorm_board_back.repository;


import groom.goorm_board_back.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import groom.goorm_board_back.domain.Board;

public interface LikeRepository extends JpaRepository<Like,Long> {

        // 좋아요 여부 확인
        boolean existsByBoard(Board board);

        // 좋아요 취소를 위한 삭제
        void deleteByBoard(Board board);

        // 게시글에 해당하는 Like 찾기
        Like findByBoard(Board board);
}
