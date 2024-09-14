package groom.goorm_board_back.dto.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class JwtDto {
    private String accessToken;
    private String refreshToken;
}
