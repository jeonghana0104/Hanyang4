package ac.kr.hanyang.backendEx.domain;

import ac.kr.hanyang.backendEx.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@Table(name = "_emp_dept")
@AllArgsConstructor
@NoArgsConstructor
public class Dept extends BaseEntity {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer odNum;
    private String deptNm;


    @JsonManagedReference
    @OneToMany(mappedBy = "dept", cascade = CascadeType.PERSIST)
    @OrderBy("odNum asc, id asc")
    private List<Team> teams = new ArrayList<Team>();
}
