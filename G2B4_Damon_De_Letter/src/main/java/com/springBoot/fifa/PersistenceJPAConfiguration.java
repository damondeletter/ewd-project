/*
 * package com.springBoot.fifa;
 * 
 * import java.util.Properties;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.EntityManagerFactory; import javax.sql.DataSource;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.dao.annotation.
 * PersistenceExceptionTranslationPostProcessor; import
 * org.springframework.jdbc.datasource.DriverManagerDataSource; import
 * org.springframework.orm.jpa.JpaTransactionManager; import
 * org.springframework.orm.jpa.JpaVendorAdapter; import
 * org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; import
 * org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter; import
 * org.springframework.transaction.PlatformTransactionManager; import
 * org.springframework.transaction.annotation.EnableTransactionManagement;
 * 
 * @Configuration
 * 
 * @EnableTransactionManagement public class PersistenceJPAConfiguration {
 * 
 * @Bean public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
 * LocalContainerEntityManagerFactoryBean em = new
 * LocalContainerEntityManagerFactoryBean(); em.setDataSource(dataSource());
 * em.setPackagesToScan(new String[] {"domain"}); JpaVendorAdapter vendorAdapter
 * = new HibernateJpaVendorAdapter(); em.setJpaVendorAdapter(vendorAdapter);
 * em.setJpaProperties(additionalProperties()); return em; }
 * 
 * @Bean private DataSource dataSource() { DriverManagerDataSource dataSource =
 * new DriverManagerDataSource();
 * dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
 * dataSource.setUrl("jdbc:mysql://localhost:3306/FifaWC");
 * dataSource.setUsername( "root" ) ;dataSource.setPassword( "" ) ;return
 * dataSource; }
 * 
 * Properties additionalProperties() { Properties properties = new Properties();
 * properties.setProperty("hibernate.hbm2ddl.auto", "create"); return
 * properties; }
 * 
 * @Bean public PlatformTransactionManager
 * transactionManager(EntityManagerFactory emf) { JpaTransactionManager
 * transactionManager = new JpaTransactionManager();
 * transactionManager.setEntityManagerFactory(emf); return transactionManager; }
 * 
 * @Bean public PersistenceExceptionTranslationPostProcessor
 * exceptionTranslation() { return new
 * PersistenceExceptionTranslationPostProcessor(); } }
 */