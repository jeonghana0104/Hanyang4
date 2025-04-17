package ac.kr.hanyang.backendEx.service;

import ac.kr.hanyang.backendEx.domain.Board;
import ac.kr.hanyang.backendEx.dto.BoardDto;
import ac.kr.hanyang.backendEx.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;


@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Page<Board> findAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return boardRepository.findAll(pageable);
    }


    public Optional<Board> findOne(Integer id) {
        return boardRepository.findById(id);
    }


    @Transactional
    public Integer update(Integer id, BoardDto.BoardAddDto dto) {
        Board board = boardRepository.findById(id).orElse(null);
        if (board == null) {
            throw new NoSuchElementException("data not found");
        }

        board.setBoardTitle(dto.getBoardTitle());
        board.setBoardContent(dto.getBoardContent());

        return board.getId();
    }

    @Transactional
    public Integer add(BoardDto.BoardAddDto dto) {

        Board board = Board.builder()
                .boardTitle(dto.getBoardTitle())
                .boardContent(dto.getBoardContent())
                .build();

        boardRepository.save(board);
        return board.getId();
    }
}
