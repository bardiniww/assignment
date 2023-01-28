package com.bardiniww.customer.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpaRepository extends AccountRepository, JpaRepository<Account, Long> {
}
