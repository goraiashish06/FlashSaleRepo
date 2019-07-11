package com.sale.flashsale.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

//import org.hibernate.dialect.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sale.flashsale.dao")
public class AppConfig {

	@Autowired
	 private Environment env;

	 @Bean
	 public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

	 HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	 vendorAdapter.setDatabase(Database.H2);
	 vendorAdapter.setGenerateDdl(true);

	 LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	 em.setDataSource(dataSource());
	 em.setPackagesToScan("com.sale.flashsale.model");
	 em.setJpaVendorAdapter(vendorAdapter);
	 em.setJpaProperties(additionalProperties());

	 return em;
	 }

	 @Bean
	 public DataSource dataSource() {
	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
	 dataSource.setUrl(env.getProperty("spring.datasource.url"));
	 dataSource.setUsername(env.getProperty("spring.datasource.username"));
	 dataSource.setPassword(env.getProperty("spring.datasource.password"));
	 return dataSource;
	 }

	 @Bean
	 public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	 JpaTransactionManager transactionManager = new JpaTransactionManager();
	 transactionManager.setEntityManagerFactory(emf);

	 return transactionManager;
	 }

	 @Bean
	 public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	 return new PersistenceExceptionTranslationPostProcessor();
	 }

	 private Properties additionalProperties() {
	 Properties properties = new Properties();
	 properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.hbm2ddl.auto"));
	 properties.setProperty("hibernate.dialect", env.getProperty("spring.jpa.hibernate.dialect"));
	 //properties.setProperty("hibernate.current_session_context_class", env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
	 //properties.setProperty("hibernate.jdbc.lob.non_contextual_creation", env.getProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation"));
	 properties.setProperty("hibernate.show_sql", env.getProperty("spring.jpa.hibernate.show_sql"));
	 properties.setProperty("hibernate.format_sql", env.getProperty("spring.jpa.hibernate.format_sql"));
	 return properties;
	}
}
