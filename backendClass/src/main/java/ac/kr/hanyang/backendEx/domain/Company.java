package ac.kr.hanyang.backendEx.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "_com_company")
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String companyNm;
    private String companyRegNum;
    private String companyCeo;
    private String companyTel;
    private String companyFax;
    private String companyEmail;
}
