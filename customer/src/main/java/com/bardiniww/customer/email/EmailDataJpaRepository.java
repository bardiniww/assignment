package com.bardiniww.customer.email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDataJpaRepository extends EmailDataRepository, JpaRepository<EmailData, Long> {

//    boolean existsByEmail(@NonNull final String email);
}
