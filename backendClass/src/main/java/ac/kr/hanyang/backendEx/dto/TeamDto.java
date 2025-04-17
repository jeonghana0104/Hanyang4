package ac.kr.hanyang.backendEx.dto;

import ac.kr.hanyang.backendEx.domain.Team;
import lombok.Data;
import lombok.Getter;


@Data
public class TeamDto {
    private Integer id;
    private String teamNm;
    private Integer odNum;

    private DeptDto dept;

    private TeamDto(Integer id, String teamNm, Integer odNum){
        this.id = id;
        this.teamNm = teamNm;
        this.odNum = odNum;
    }

    private TeamDto(Integer id, String teamNm, Integer odNum, DeptDto dept){
        this.id = id;
        this.teamNm = teamNm;
        this.odNum = odNum;
        this.dept = dept;
    }

    public static TeamDto of(Team team){
        if(team == null ) return null;
        else
            return new TeamDto(team.getId(),
                    team.getTeamNm(),
                    team.getOdNum(),
                DeptDto.of(team.getDept())
        );
    }

    public static TeamDto of(Integer id, String teamNm, Integer odNum){
        return new TeamDto(id, teamNm, odNum);
    }


    public TeamDto(Team team) {
        id = team.getId();
        teamNm = team.getTeamNm();
        odNum = team.getOdNum();
    }


    @Getter
    public static class TeamAddDto {
        private Integer deptId;
        private String deptNm;
        private String teamNm;
        private Integer odNum;
    }
}
