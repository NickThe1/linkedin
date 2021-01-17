package com.nick.software.link.linkedin.persistence.repository;

import com.nick.software.link.linkedin.persistence.entity.Account;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @EntityGraph(value = "Account.Resume")
    Optional<Account> findByUsername(String username);

    Account findByEmail(String email);
}
