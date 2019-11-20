package com.jitihn.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.jitihn.dto.CompanyDTO;
import com.jitihn.model.Company;
import com.jitihn.repository.CompanyRepository;

@ApplicationScoped
public class CompanyService {

    @Inject
    CompanyRepository companyRepository;

    public List<CompanyDTO> getCompanies() {
        return companyRepository.getCompanies();
    }

    public void saveCompany(Company company) {
        companyRepository.save(company);
    }
}