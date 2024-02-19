package br.com.acheipreco.acheiprecoApi.Repository;

import br.com.acheipreco.acheiprecoApi.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Company findByEmpresaCnpj(String empresaCnpj);
}
