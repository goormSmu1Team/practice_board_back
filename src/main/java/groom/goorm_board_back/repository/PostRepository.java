package groom.goorm_board_back.repository;

import groom.goorm_board_back.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}