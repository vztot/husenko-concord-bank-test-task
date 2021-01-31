package com.vztot.dao;

import com.vztot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT fio FROM users WHERE id = ?1", nativeQuery = true)
    Optional<String> getUserFioById(Long id);

//// native query should work faster that's why not jpql:
//    @Query(value = "SELECT fio FROM User WHERE id = ?1")
//    Optional<String> getUserFioById(Long id);
}
