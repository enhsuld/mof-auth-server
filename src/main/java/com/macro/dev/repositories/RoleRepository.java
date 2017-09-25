package com.macro.dev.repositories;

import com.macro.dev.models.TcRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * LutUser repository for CRUD operations.
 */
public interface RoleRepository extends JpaRepository<TcRole,Long> {

}
