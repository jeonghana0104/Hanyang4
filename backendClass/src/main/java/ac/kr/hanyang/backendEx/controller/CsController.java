package ac.kr.hanyang.backendEx.controller;

import ac.kr.hanyang.backendEx.common.ResponseMapper;
import ac.kr.hanyang.backendEx.service.CsService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = {"cs/"})
public class CsController {

    private final CsService csService;
    private final ResponseMapper responseMapper;

    @GetMapping(value = "list")
    public void findList(HttpServletResponse response) throws IOException {
        responseMapper.defaultJsonResponse(
                response,
                HttpStatus.OK,
                "Cs List Success!",
                this.csService.findList()
        );
    }
}
