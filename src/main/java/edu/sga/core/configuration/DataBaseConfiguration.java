package edu.sga.core.configuration;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration {
	
	
	public Properties getProperties() {
		Properties properties = new Properties();
		//propiedad que define el lenguaje que va utilizar para conectarse a mysql
			properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect");
		//propiedad que servira para mostrar los resultados de la consulta a mysql
			properties.put("hibernate.dialect.storage_engine","InnoDB");
			properties.put("show_sql","true");
		
		return properties;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/sga2018");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	@Bean
	@Primary
	//para obtener la unica sesion que se conectara a mysql
	public LocalSessionFactoryBean getSessionFactory() {
		//instanciar el objeto que se conectara a la base de datos
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		//obtener el origen de datos
		sessionFactoryBean.setDataSource(getDataSource());
		//indicar el paquete de clases modelo
		sessionFactoryBean.setPackagesToScan("edu.sga.core.model");
		//indicar las propiedades que tendra la conexion
		sessionFactoryBean.setHibernateProperties(getProperties());
		return sessionFactoryBean;
	}
	@Bean
	//este objeto que se va inyectar se va construir en otra clase
	@Autowired
	//gestionara todas las transacciones que se haran de java hacia mysql
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		//obtiene el objeto creado de la sesion
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

}

