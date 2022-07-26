package com.example.advancejavaassignmentfetchandsave.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class EshopOrdersDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.eshop-orders")
    public DataSourceProperties eshopOrdersDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "eshop-orders")
    @Primary
    @ConfigurationProperties("spring.datasource.eshop-orders.hikari")
    public DataSource eshopOrdersDataSource() {
        return eshopOrdersDataSourceProperties()
          .initializeDataSourceBuilder()
          .build();
    }

    @Bean(name = "eshopOrdersTemplate")
    public JdbcTemplate crudTemplate(@Qualifier("eshop-orders") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}