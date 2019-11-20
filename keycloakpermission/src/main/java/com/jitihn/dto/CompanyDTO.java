package com.jitihn.dto;

import java.time.LocalDateTime;
import com.jitihn.model.Company;

public class CompanyDTO {
    private String pid;
    private String name;
    private String description;
    private String address;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;

    public CompanyDTO(Company company) {
        this.pid = company.getName();
        this.name = company.getName();
        this.description = company.getDescription();
        this.address = company.getAddress();
        this.createdDateTime = company.getCreatedDateTime();
        this.updatedDateTime = company.getUpdatedDateTime();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CompanyDTO [address=" + address + ", description=" + description + ", name=" + name + ", pid=" + pid
                + "]";
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

}