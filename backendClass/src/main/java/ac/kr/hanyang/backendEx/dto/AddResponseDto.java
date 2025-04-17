package ac.kr.hanyang.backendEx.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class AddResponseDto {
    private Integer id;

    public AddResponseDto (Integer id) {
        this.id = id;
    }

}
