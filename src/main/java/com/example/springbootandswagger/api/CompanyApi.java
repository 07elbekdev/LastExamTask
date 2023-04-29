package com.example.springbootandswagger.api;

import com.example.springbootandswagger.dto.modelsRequest.CompanyRequest;
import com.example.springbootandswagger.dto.modelsResponse.CompanyResponse;
import com.example.springbootandswagger.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class CompanyApi {

    private final CompanyService companyService;

    @PostMapping("/create/company")
    public String createCompany(@RequestBody CompanyRequest companyRequest) {
        companyService.createCompany(companyRequest);
        return "Company successfully created!";
    }

    @GetMapping("/getAll/Companies")
    public List<CompanyResponse> getAllCompanies() {
        return companyService.findAllCompanies();
    }

    @GetMapping("/get_companyBy/{id}")
    public CompanyResponse getById(@PathVariable Long id) {
        return companyService.findCompanyById(id);
    }

    @DeleteMapping("/delete/companyBy/{id}")
    public String deleteById(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
        return "Company successfully deleted!";
    }

    @PutMapping("/update/companyBy/{id}")
    public String updateById(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) {
        companyService.updateCompanyById(id, companyRequest);
        return "Company successfully updated!";
    }
}