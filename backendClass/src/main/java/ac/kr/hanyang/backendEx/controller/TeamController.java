package ac.kr.hanyang.backendEx.controller;

import ac.kr.hanyang.backendEx.domain.Team;
import ac.kr.hanyang.backendEx.dto.AddResponseDto;
import ac.kr.hanyang.backendEx.dto.ResponseDto;
import ac.kr.hanyang.backendEx.dto.TeamDto;
import ac.kr.hanyang.backendEx.service.TeamService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"team/"})
public class TeamController {
    private final TeamService teamService;

    //팀 목록
    @GetMapping("list")
    public ResponseDto list() {

        List<Team> list = teamService.findAll();
        List<TeamDto> collect = list.stream()
                .map(TeamDto::new)
                .collect(Collectors.toList());

        return new ResponseDto(HttpStatus.OK, "Team list", false, 1, (long)list.size(), collect);
    }

    //선택된 부서에 해당되는 팀 목록
    @GetMapping("list/dept/{deptId}")
    public ResponseDto listByDeptId(HttpServletResponse response
            , @PathVariable("deptId") Integer deptId
    ) throws IOException {

        List<Team> list = teamService.findByDeptId(deptId);
        List<TeamDto> collect = list.stream()
                .map(m ->  new TeamDto(m))
                .collect(Collectors.toList());

        return new ResponseDto(HttpStatus.OK, "Team list by Dept id", false, 1, (long)list.size(), collect);
    }

    @PostMapping("add")
    public AddResponseDto add(HttpServletResponse response
            ,@Validated @RequestBody TeamDto.TeamAddDto body
    ) throws IOException {

        Integer id= teamService.add(body);

        return new AddResponseDto(id);
    }

    @PutMapping("update/{id}")
    public AddResponseDto update(HttpServletResponse response
            ,@PathVariable("id") Integer id
            ,@Validated @RequestBody TeamDto.TeamAddDto body
    ) throws IOException {

        Team team = teamService.findOne(teamService.update(id, body))
                .orElseThrow(() -> new IllegalArgumentException("Team not found: " + id));
        return new AddResponseDto(team.getId());
    }
}
