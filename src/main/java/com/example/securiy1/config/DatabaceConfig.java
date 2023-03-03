package com.example.securiy1.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
//@PropertySource("classpath:/application.yml")
@ConfigurationProperties(prefix = "application")
//@Value("${spring.profiles.active}")

@PropertySource(value = {"application.yml"}, factory = YamlLoadFactory.class)

public class DatabaceConfig {
	
	@Bean(name="dataSource")
	@ConfigurationProperties("spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}
}
//https://pooney.tistory.com/88 확인하기