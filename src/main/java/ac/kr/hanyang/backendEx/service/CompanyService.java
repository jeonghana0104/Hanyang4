package ac.kr.hanyang.backendEx.service;

import ac.kr.hanyang.backendEx.domain.Company;
import ac.kr.hanyang.backendEx.dto.CompanyDto;
import ac.kr.hanyang.backendEx.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }
    public Company findOne(Integer id) {
        return companyRepository.findById(id).orElse(null);
    }


    @Transactional
    public Integer update(Integer id, CompanyDto.CompanyAddDto dto){
        Company company = companyRepository.findById(id).orElse(null);
        if (company == null) {
            throw new NoSuchElementException("data not found");
        }
        if(dto.getCompanyNm() != null && !dto.getCompanyNm().equals("")) company.setCompanyNm(dto.getCompanyNm());
        if(dto.getCompanyRegNum() != null && !dto.getCompanyRegNum().equals("")) company.setCompanyRegNum(dto.getCompanyRegNum());
        company.setCompanyCeo(dto.getCompanyCeo());
        company.setCompanyTel(dto.getCompanyTel());
        company.setCompanyFax(dto.getCompanyFax());
        company.setCompanyEmail(dto.getCompanyEmail());
        return company.getId();
    }

}
