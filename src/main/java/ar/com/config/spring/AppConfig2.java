package ar.com.config.spring;

import java.util.Properties;

import javax.sql.DataSource;



import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

public class AppConfig2 {

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource driverManager = new DriverManagerDataSource("jdbc:mysql://localhost:3306/spring", "root", "root");
		driverManager.setDriverClassName("com.mysql.jdbc.Driver");
		return driverManager;
	}
	@Bean 
	public AnnotationSessionFactoryBean sessionFactoryBean(){
		AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
		
		Class[] annotatedClasses = {Object.class};
		sessionFactoryBean.setAnnotatedClasses(annotatedClasses);
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		sessionFactoryBean.setHibernateProperties(hibernateProperties);
		sessionFactoryBean.setDataSource(dataSource());
		
		return sessionFactoryBean;
	}
}
