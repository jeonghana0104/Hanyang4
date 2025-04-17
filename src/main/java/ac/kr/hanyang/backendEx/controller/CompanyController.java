package ac.kr.hanyang.backendEx.controller;

import ac.kr.hanyang.backendEx.domain.Company;
import ac.kr.hanyang.backendEx.dto.AddResponseDto;
import ac.kr.hanyang.backendEx.dto.CompanyDto;
import ac.kr.hanyang.backendEx.dto.ResponseDto;
import ac.kr.hanyang.backendEx.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"company/"})
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("list")
    public ResponseDto list() throws IOException {
        List<Company> list = companyService.findAll();
        List<CompanyDto> collect = list.stream()
                .map(m ->  new CompanyDto(m))
                .collect(Collectors.toList());

/* 코드간결화
      List<CompanyDto> collect = list.stream()
                .map(CompanyDto::new)
                .collect(Collectors.toList());
*/
        return new ResponseDto(HttpStatus.OK, "company list", false, 1, (long)list.size(), collect);
    }

    @PutMapping("update/{id}")
    public AddResponseDto add(@PathVariable("id") Integer id
            ,@Validated @RequestBody CompanyDto.CompanyAddDto body
    ) throws IOException {
        companyService.update(id, body);
        Company company = companyService.findOne(id);
        return new AddResponseDto(id);
    }
}
