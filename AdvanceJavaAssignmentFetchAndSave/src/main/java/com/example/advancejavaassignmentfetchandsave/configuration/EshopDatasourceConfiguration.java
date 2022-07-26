package com.example.advancejavaassignmentfetchandsave.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class EshopDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.eshop")
    public DataSourceProperties eshopDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "eshop")
    public DataSource eshopDataSource() {
        return eshopDataSourceProperties()
          .initializeDataSourceBuilder()
          .build();
    }

    @Bean(name = "eshopTemplate")
    public JdbcTemplate crudTemplate(@Qualifier("eshop") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}