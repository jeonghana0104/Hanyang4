package ac.kr.hanyang.backendEx.controller;


import ac.kr.hanyang.backendEx.domain.Board;
import ac.kr.hanyang.backendEx.dto.*;
import ac.kr.hanyang.backendEx.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"notice/"})
public class BoardController {

    private final BoardService boardService;


    @GetMapping("list/{page}/{size}")
    public ResponseDto list( @PathVariable("page") int page
            , @PathVariable("size") int size) throws IOException {
        Page<Board> list = boardService.findAll(page, size);
        List<BoardDto> collect = list.stream()
                .map(m -> BoardDto.of(m))
                .collect(Collectors.toList());
        return new ResponseDto(HttpStatus.OK, "Board list", list.hasNext(), list.getTotalPages(), list.getTotalElements(), collect);
    }

    @GetMapping("view/{id}")
    public ResponseDto view(@PathVariable("id") int id) throws IOException {

        Board board = boardService.findOne(id).orElse(null);
        return new ResponseDto(HttpStatus.OK, "view board data", false, 0, (long) 0, BoardDto.of(board));

    }

    @PostMapping("add")
    public ResponseDto add(
            @Validated @RequestBody BoardDto.BoardAddDto body
    ) throws IOException {

        Board board = boardService.findOne(boardService.add(body)).orElse(null);
        return new ResponseDto(HttpStatus.OK, "add board data", false, 0, (long) 0, board);
    }

    @PutMapping("update/{id}")
    public AddResponseDto update(@PathVariable("id") Integer id
            , @Validated @RequestBody BoardDto.BoardAddDto body
    ) throws IOException {

        Board board = boardService.findOne(boardService.update(id, body)).orElse(null);
        return new AddResponseDto(board.getId());
    }


}






