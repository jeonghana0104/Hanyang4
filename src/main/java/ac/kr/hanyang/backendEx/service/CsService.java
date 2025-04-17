package ac.kr.hanyang.backendEx.service;

import ac.kr.hanyang.backendEx.dto.CsDto;
import ac.kr.hanyang.backendEx.repository.CsRepositoryMysql;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CsService {
    private final CsRepositoryMysql csRepositoryMysql;

    public List<CsDto> findList(){
        List<CsDto> list = csRepositoryMysql.findList();
        return list;
    }
}
