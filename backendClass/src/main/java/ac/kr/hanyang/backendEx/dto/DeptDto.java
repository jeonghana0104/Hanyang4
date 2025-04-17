package ac.kr.hanyang.backendEx.dto;

import ac.kr.hanyang.backendEx.domain.Dept;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
@NoArgsConstructor
public class DeptDto {
    private Integer id;
    private String deptNm;
    private Integer odNum;
    private List<TeamDto> teams;


    private DeptDto(Integer id, String deptNm, Integer odNum){
        this.id = id;
        this.deptNm = deptNm;
        this.odNum = odNum;
    }
    public static DeptDto of(Dept dept){
        if(dept == null)  return null;
        else return new DeptDto(dept.getId(), dept.getDeptNm(), dept.getOdNum());
    }

    public DeptDto(Dept dept) {
        id = dept.getId();
        deptNm = dept.getDeptNm();
        odNum = dept.getOdNum();

    }

    public DeptDto(Dept dept, boolean sub) {
        id = dept.getId();
        deptNm = dept.getDeptNm();
        odNum = dept.getOdNum();
        if(sub) {
            teams = dept.getTeams().stream()
                    .map(TeamDto::new)
                    .collect(toList());
        }
    }

    @Getter
    public static class DeptAddDto {
        private String deptNm;
        private Integer odNum;
        private String outYn;
    }


}
