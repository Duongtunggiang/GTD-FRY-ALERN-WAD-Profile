package com.gtd.profile.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url:jdbc:h2:mem:devdb}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username:sa}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password:}")
    private String dataSourcePassword;

    @Bean
    @Primary
    public DataSource dataSource() {
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.url(dataSourceUrl);
        builder.username(dataSourceUsername);
        builder.password(dataSourcePassword);
        
        // Auto-detect and set driver based on URL
        if (dataSourceUrl != null && dataSourceUrl.startsWith("jdbc:postgresql:")) {
            builder.driverClassName("org.postgresql.Driver");
        } else if (dataSourceUrl != null && dataSourceUrl.startsWith("jdbc:h2:")) {
            builder.driverClassName("org.h2.Driver");
        }
        // Spring Boot will auto-detect for other database types if driver not set
        
        return builder.build();
    }
}

