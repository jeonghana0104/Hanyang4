package ac.kr.hanyang.backendEx.service;


import ac.kr.hanyang.backendEx.domain.Dept;
import ac.kr.hanyang.backendEx.domain.Team;
import ac.kr.hanyang.backendEx.dto.TeamDto;
import ac.kr.hanyang.backendEx.repository.DeptRepository;
import ac.kr.hanyang.backendEx.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final DeptRepository deptRepository;

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Optional<Team> findOne(Integer id) {
        return teamRepository.findById(id);
    }

    public List<Team> findByDeptId(Integer id) {
        return teamRepository.findByDeptId(id);
    }

    @Transactional
    public Integer add(TeamDto.TeamAddDto dto) {

        //연관 엔티티 조회
        Dept dept = deptRepository.findById(dto.getDeptId())
                .orElseThrow(() -> new NoSuchElementException("부서 지정이 잘못되었습니다"));

        //팀생성
        Team team = Team.builder()
                .teamNm(dto.getTeamNm())
                .odNum(dto.getOdNum())
                .dept(dept)
                .build();
        //연관 부서 set
        team = team.addTeam(team, dept);

        //팀 저장
        teamRepository.save(team);

        return team.getId();
    }


    @Transactional
    public Integer update(Integer id, TeamDto.TeamAddDto dto){

        Team team = teamRepository.findById(id).orElse(null);
        if (team == null) {
            throw new NoSuchElementException("Team data not found");
        }

        team.setTeamNm(dto.getTeamNm());
        team.setOdNum(dto.getOdNum());

        return team.getId();
    }
}
