package com.bs.exercice.loggingservice.dao.repository;

import com.bs.exercice.loggingservice.dao.domain.LoggingValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio Spring Data para la entidad LoggingValues
 */
@Repository
public interface LoggingValueRepository extends JpaRepository<LoggingValue, Long> {
}