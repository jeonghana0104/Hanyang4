package ac.kr.hanyang.backendEx.dto;

import ac.kr.hanyang.backendEx.domain.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class CompanyDto {
    private Integer id;
    private String companyNm;
    private String companyRegNum;
    private String companyCeo;
    private String companyTel;
    private String companyFax;
    private String companyEmail;

    public CompanyDto(Company entity) {
        id = entity.getId();
        companyNm = entity.getCompanyNm();
        companyRegNum = entity.getCompanyRegNum();
        companyCeo = entity.getCompanyCeo();
        companyTel = entity.getCompanyTel();
        companyFax = entity.getCompanyFax();
        companyEmail = entity.getCompanyEmail();
    }

    @Getter
    public static class CompanyAddDto {
        private String companyNm;
        private String companyRegNum;
        private String companyCeo;
        private String companyTel;
        private String companyFax;
        private String companyEmail;
    }
}
