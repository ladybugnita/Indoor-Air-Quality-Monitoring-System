package com.IAQMS.IAQMS.Repository;

import com.IAQMS.IAQMS.Model.AdminLoginData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminLoginRepository extends JpaRepository<AdminLoginData , Integer> {
    Optional<AdminLoginData> findByUsername(String username);
}
