package groom.goorm_board_back.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardUpdateRequestDto {
    //게시판 수정 전용 dto
    private String title;
    private String content;
}
