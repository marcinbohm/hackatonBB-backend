package com.hackatonbb.repository;

import com.hackatonbb.entity.Installation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstallationRepository extends JpaRepository<Installation, Integer> {

}
