package com.hack.deprem.repository;

import com.hack.deprem.model.Assistance;
import com.hack.deprem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistanceRepository  extends JpaRepository<Assistance, String> {
    boolean existsByFromCity(int fromCity);
    Assistance getAssistanceByFromCity(int fromCity);
}
