package com.brokerage;

import com.brokerage.dao.ContractDAO;
import com.brokerage.model.Contract;
import com.brokerage.service.ContractService;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.TimeZone;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EntityScan(basePackageClasses = {
		BrokerageApplication.class,
		Jsr310JpaConverters.class
})
public class BrokerageApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(BrokerageApplication.class, args);
	}

}
