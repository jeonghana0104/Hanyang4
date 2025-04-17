package ac.kr.hanyang.backendEx.repository;

import ac.kr.hanyang.backendEx.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface TeamRepository extends JpaRepository<Team, Integer>, JpaSpecificationExecutor<Team> {
    List<Team> findByDeptId(Integer dept_Idx);
}
