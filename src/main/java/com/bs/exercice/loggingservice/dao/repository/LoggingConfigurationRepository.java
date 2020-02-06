package com.bs.exercice.loggingservice.dao.repository;

import com.bs.exercice.loggingservice.dao.domain.LoggingConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repositorio Spring Data para la entidad LoggingConfiguration
 */
@Repository
public interface LoggingConfigurationRepository extends JpaRepository<LoggingConfiguration, Long> {

    @Query("select lc from LoggingConfiguration lc")
    LoggingConfiguration getInitialLoggingConfiguration();
}