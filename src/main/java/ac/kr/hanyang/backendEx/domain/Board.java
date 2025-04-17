package ac.kr.hanyang.backendEx.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name="_com_board")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Integer id;

    private String boardTitle;
    private String boardContent;

    @Builder.Default
    private Integer hitCnt = 0;

}
