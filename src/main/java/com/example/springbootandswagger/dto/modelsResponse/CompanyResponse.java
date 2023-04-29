package com.example.springbootandswagger.dto.modelsResponse;

import lombok.Data;

@Data
public class CompanyResponse {

    private Long companyId;
    private String companyName;
    private String locatedCountry;
}
