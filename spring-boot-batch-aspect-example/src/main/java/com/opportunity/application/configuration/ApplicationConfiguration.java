package com.opportunity.application.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Import(value = BatchConfiguration.class)
//public class ApplicationConfiguration extends WebSecurityConfigurerAdapter {
public class ApplicationConfiguration {

	/*@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests()
				.antMatchers("/h2_console/**").permitAll();

		httpSecurity.csrf().disable();

		httpSecurity.headers().frameOptions().disable();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		auth.inMemoryAuthentication().withUser("user").password("password");
	}*/
}
