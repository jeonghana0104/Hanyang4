package ac.kr.hanyang.backendEx.controller;

import ac.kr.hanyang.backendEx.domain.Dept;
import ac.kr.hanyang.backendEx.dto.AddResponseDto;
import ac.kr.hanyang.backendEx.dto.ResponseDto;
import ac.kr.hanyang.backendEx.dto.DeptDto;
import ac.kr.hanyang.backendEx.service.DeptService;
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
@RequestMapping(value = {"dept/"})
public class DeptController {
    private final DeptService deptService;

    //부서목록
    @GetMapping("list")
    public ResponseDto list() {
        List<Dept> list = deptService.findAll();
        List<DeptDto> collect = list.stream()
                .map(DeptDto::new)
                .collect(Collectors.toList());

        return new ResponseDto(HttpStatus.OK, "dept list", false, 1, (long)list.size(), collect);
    }

    //부서목록과 연결된 팀 목록 같이
    @GetMapping("list/with/sub")
    public ResponseDto listSub(HttpServletResponse response) throws IOException {
        List<Dept> list = deptService.findAll();
        List<DeptDto> collect = list.stream()
                .map(m ->  new DeptDto(m, true))
                .collect(Collectors.toList());

        return new ResponseDto(HttpStatus.OK, "dept list", false, 1, (long)list.size(), collect);
    }

    @PostMapping("add")
    public AddResponseDto add(HttpServletResponse response
            ,@Validated @RequestBody DeptDto.DeptAddDto body
    ) throws IOException {

        Integer id = deptService.add(body);
        return new AddResponseDto(id);
    }

    @PutMapping("update/{id}")
    public AddResponseDto update(HttpServletResponse response
            ,@PathVariable("id") Integer id
            ,@Validated @RequestBody DeptDto.DeptAddDto body
    ) throws IOException {

        Dept dept = deptService.findOne(deptService.update(id, body))
                .orElseThrow(() -> new IllegalArgumentException("Department not found: " + id));
        return new AddResponseDto(dept.getId());
    }
}
