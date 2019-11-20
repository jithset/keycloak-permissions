package com.jitihn.repository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.jitihn.dto.CompanyDTO;
import com.jitihn.model.Company;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CompanyRepository implements PanacheRepository<Company> {
    public Company findByPid(String pid) {
        return Company.find("pid", pid).firstResult();
    }

    @Transactional
    public void save(Company company) {
        company.setPid(UUID.randomUUID().toString());
        LocalDateTime currentDateTime = LocalDateTime.now();
        company.setCreatedDateTime(currentDateTime);
        company.setUpdatedDateTime(currentDateTime);
        company.persist();
    }

    public List<CompanyDTO> getCompanies() {
        Stream<Company> companies = Company.streamAll();
        List<CompanyDTO> companyDtos = companies.map(p -> new CompanyDTO(p))
                .sorted(Comparator.comparing(CompanyDTO::getCreatedDateTime).reversed()).collect(Collectors.toList());
        return companyDtos;
    }
}