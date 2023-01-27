package com.bardiniww.phone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneDataJpaRepository extends PhoneDataRepository, JpaRepository<PhoneData, Long> {
}
