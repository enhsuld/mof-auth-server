package com.macro.dev.repositories;

import com.macro.dev.models.TcUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * LutUser repository for CRUD operations.
 */
public interface UserRepository extends JpaRepository<TcUser,Long> {

    @Query("SELECT t FROM TcUser t where t.userNm = ?1")
    TcUser findByUsername(String username);
}
