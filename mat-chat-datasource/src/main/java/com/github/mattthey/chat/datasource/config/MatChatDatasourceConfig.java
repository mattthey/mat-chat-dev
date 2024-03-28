package com.github.mattthey.chat.datasource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class MatChatDatasourceConfig {
    @ConfigurationProperties("mat-chat.datasource.main")
    @Bean//("matChatDataSourceMain")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .build();
    }

    @Bean//("matChatTransactionManagerMain")
    public PlatformTransactionManager transactionManager(
            final DataSource dataSource
    ) {
        return new DataSourceTransactionManager(dataSource);
    }
}
