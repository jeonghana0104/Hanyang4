package ac.kr.hanyang.backendEx.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@SuperBuilder
@Table(name = "_com_cs")
@AllArgsConstructor
@NoArgsConstructor
public class Cs {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String csNm;
    private String csEnm;
    private String csTel;
}
