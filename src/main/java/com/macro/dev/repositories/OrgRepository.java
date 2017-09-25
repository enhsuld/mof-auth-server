package com.macro.dev.repositories;

import com.macro.dev.models.TcOrg;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * LutUser repository for CRUD operations.
 */
public interface OrgRepository extends JpaRepository<TcOrg,Long> {

}
