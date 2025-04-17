package ac.kr.hanyang.backendEx.domain;

import ac.kr.hanyang.backendEx.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_emp_team")
public class Team extends BaseEntity {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String teamNm;
    private int odNum;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_idx")
    private Dept dept;

    public static Team addTeam(Team team, Dept dept) {
        team.setDept(dept);
        return team;
    }

    //==연관관계인 부서정보==//
    public void setDept(Dept dept) {
        if(this.dept != null){
            this.dept.getTeams().remove(this);
        }
        this.dept = dept;
        if (dept != null && !dept.getTeams().contains(this)) {
            dept.getTeams().add(this);
        }
    }

}
