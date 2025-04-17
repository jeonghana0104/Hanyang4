package ac.kr.hanyang.backendEx.service;

import ac.kr.hanyang.backendEx.domain.Dept;
import ac.kr.hanyang.backendEx.dto.DeptDto;
import ac.kr.hanyang.backendEx.repository.DeptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DeptService {
    private final DeptRepository deptRepository;

    public List<Dept> findAll() {
        return deptRepository.findAll();
    }

    public Optional<Dept> findOne(Integer id) {
        return deptRepository.findById(id);
    }

    @Transactional
    public Integer add(DeptDto.DeptAddDto dto){
        validateDuplicateNm(dto);

        //부서 생성
        Dept dept = Dept.builder()
                .deptNm(dto.getDeptNm())
                .odNum(dto.getOdNum())
                .build();

        deptRepository.save(dept);
        return dept.getId();
    }

    private void validateDuplicateNm(DeptDto.DeptAddDto dto) {
        List<Dept> list = deptRepository.findByDeptNm(dto.getDeptNm());
        if (!list.isEmpty()) {
            throw new IllegalStateException("이미 동일한 부서명이 존재합니다.");
        }
    }

    @Transactional
    public Integer update(Integer id, DeptDto.DeptAddDto dto){

        Dept dept = deptRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Dept data not found : " + id ));

        dept.setDeptNm(dto.getDeptNm());
        dept.setOdNum(dto.getOdNum());
        deptRepository.save(dept);
        return dept.getId();
    }
}
