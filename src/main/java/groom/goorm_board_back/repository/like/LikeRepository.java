package groom.goorm_board_back.repository.like;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class LikeRepository {

    private final LikeJpaRepository likeJpaRepository;
}
