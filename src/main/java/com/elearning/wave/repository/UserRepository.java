package com.elearning.wave.repository;

import com.elearning.wave.model.base.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByFullnameAndEmail(String fullname, String email);
    Optional<Users> findByFullname(String fullname);
    Optional<Users> findByEmail(String email);
}
