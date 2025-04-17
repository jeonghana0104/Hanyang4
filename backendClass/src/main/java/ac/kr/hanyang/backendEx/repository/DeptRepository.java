package ac.kr.hanyang.backendEx.repository;

import ac.kr.hanyang.backendEx.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer>, JpaSpecificationExecutor<Dept> {
    List<Dept> findByDeptNm(String deptNm);
}
