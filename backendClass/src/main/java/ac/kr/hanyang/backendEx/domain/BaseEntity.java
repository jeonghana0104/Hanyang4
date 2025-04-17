package ac.kr.hanyang.backendEx.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Getter
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
  @Column(name = "reg_dtm", nullable = false, updatable = false)
  @CreatedDate
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime regDtm;

  @Column(name = "up_dtm", nullable = false)
  @LastModifiedDate
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime upDtm;

  @Builder.Default
  @Column(name = "reg_idx")
  private Integer regId = 1;

  @Builder.Default
  private String regNm = "홍길동";

  @Column(name = "up_idx")
  private Integer upId;

  private String upNm;

  // Getters
  public LocalDateTime getRegDtm() { return regDtm; }
  public LocalDateTime getUpDtm() { return upDtm; }
}