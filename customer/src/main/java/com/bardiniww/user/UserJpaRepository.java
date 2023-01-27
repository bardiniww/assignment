package com.bardiniww.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends UserRepository, JpaRepository<User, Long> {
}
