package ar.com.config.spring;

import java.util.Properties;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import ar.com.DataLayer.data.DataLayerImple;
import ar.com.DataLayer.data.DataLayerImple;
import ar.com.repository.Repository;


@Configuration
@EnableJpaRepositories(basePackages="ar.com.repository")
public class AppConfig {

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource driverManager = new DriverManagerDataSource("jdbc:mysql://localhost:3306/test", "root", "root");
		driverManager.setDriverClassName("com.mysql.jdbc.Driver");
		return driverManager;
	}
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setPackagesToScan("ar.com.model.domain");
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		entityManagerFactory.setJpaProperties(hibernateProperties);
		
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactory.setDataSource(dataSource());
		
		return entityManagerFactory;
	}
	@Bean
	public Repository ReadRepository(){
		return new DataLayerImple();
	}
	
	
}
