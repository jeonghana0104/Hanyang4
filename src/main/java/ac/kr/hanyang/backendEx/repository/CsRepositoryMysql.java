package ac.kr.hanyang.backendEx.repository;

import ac.kr.hanyang.backendEx.dto.CsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CsRepositoryMysql {
    public List<CsDto> findList();
}
