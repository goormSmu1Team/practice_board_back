package groom.goorm_board_back.repository;

import groom.goorm_board_back.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}