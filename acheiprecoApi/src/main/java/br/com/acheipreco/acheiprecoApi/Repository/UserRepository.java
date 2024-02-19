package br.com.acheipreco.acheiprecoApi.Repository;

import br.com.acheipreco.acheiprecoApi.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
    UserDetails findByEmail(String email);
}
