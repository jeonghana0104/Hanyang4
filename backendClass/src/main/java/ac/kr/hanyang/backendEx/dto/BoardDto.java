package ac.kr.hanyang.backendEx.dto;

import ac.kr.hanyang.backendEx.domain.Board;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

    private Integer id;
    private String boardTitle;
    private String boardContent;
    private Integer hitCnt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime regDtm;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime upDtm;

    public static BoardDto of(Board board) {
        if (board == null) return null;
        else
            return BoardDto.builder()
                    .id(board.getId())
                    .boardTitle(board.getBoardTitle())
                    .boardContent(board.getBoardContent())
                    .regDtm(board.getRegDtm())
                    .hitCnt(board.getHitCnt())
                    .build();
    }


    @Getter
    public static class BoardAddDto {
        private String boardTitle;
        private String boardContent;
    }

}
