package com.billyang.girl;

import com.billyang.girl.multitenant.DataSourceBasedMultiTenantConnectionProviderImpl;
import com.billyang.girl.multitenant.MultiTenantConstants;
import com.billyang.girl.multitenant.MultiTenantFilter;
import com.billyang.girl.multitenant.TenantIdentifierResolver;
import org.hibernate.MultiTenancyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.PersistenceContext;
import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ServletComponentScan
@EntityScan("com.billyang.girl.domain.*")
//@EntityScan("basePackageClasses=Girl.class")
@ComponentScan(basePackages = "com.billyang.girl.*")
@EnableJpaRepositories(basePackages = "com.billyang.girl.*")
public class GirlApplication {
	@Autowired
	DataSourceBasedMultiTenantConnectionProviderImpl dsProvider;
	@Autowired
	TenantIdentifierResolver tenantResolver;
	@Autowired
	AutowireCapableBeanFactory beanFactory;
	/**
	 * Creates the default "master" datasource
	 * @return
	 */
	@Bean @Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * Configures the Hibernate JPA service with multi-tenant support enabled.
	 * @param builder
	 * @return
	 */
	@PersistenceContext
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		Map<String, Object> props = new HashMap<>();
		props.put("hibernate.multiTenancy", MultiTenancyStrategy.SCHEMA.name());
		props.put("hibernate.multi_tenant_connection_provider", dsProvider);
		props.put("hibernate.tenant_identifier_resolver", tenantResolver);

		LocalContainerEntityManagerFactoryBean result = builder.dataSource(dataSource())
				.persistenceUnit(MultiTenantConstants.TENANT_KEY)
				.properties(props)
				.packages("com").build();
		result.setJpaVendorAdapter(jpaVendorAdapter());
		return result;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		return hibernateJpaVendorAdapter;
	}
	@Bean
	public FilterRegistrationBean myFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		Filter tenantFilter = new MultiTenantFilter();
		beanFactory.autowireBean(tenantFilter);
		registration.setFilter(tenantFilter);
		registration.addUrlPatterns("/*");
		return registration;
	}
	public static void main(String[] args) {
		SpringApplication.run(GirlApplication.class, args);
	}
}
