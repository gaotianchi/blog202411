package com.gaotianchi.backend.presistence.repositity;

import com.gaotianchi.backend.presistence.entity.EUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RUser extends JpaRepository<EUser, Short> {
    EUser findByUsername(String username);
    EUser findFirstBy();
}
