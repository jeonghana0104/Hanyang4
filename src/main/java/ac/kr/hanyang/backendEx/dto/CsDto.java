package ac.kr.hanyang.backendEx.dto;


import ac.kr.hanyang.backendEx.domain.Cs;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static java.util.stream.Collectors.toList;

@Getter
@Setter
@NoArgsConstructor
public class CsDto {
    private Integer id;
    private String csNm;
    private String csEnm;
    private String csTel;


    public static CsDto of(Cs cs) {
        return new CsDto(cs);
    }

    public CsDto(Cs cs) {
        id = cs.getId();
        csNm = cs.getCsNm();
        csEnm = cs.getCsEnm();
        csTel = cs.getCsTel();
    }
}
