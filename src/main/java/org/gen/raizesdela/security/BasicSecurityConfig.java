package org.gen.raizesdela.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/**").permitAll()
		.antMatchers("/usuario/logar").permitAll()
		.antMatchers("/usuario/cadastrar").permitAll()
		.antMatchers("/usuario/{id}").permitAll()
		.antMatchers(HttpMethod.GET,"/produto").permitAll()
		.antMatchers(HttpMethod.GET,"/produto/{id}").permitAll()
		.antMatchers(HttpMethod.GET,"/produto/nome/{nome}").permitAll()
		.antMatchers("/produto").permitAll()
		.antMatchers("/produto/{id}").permitAll()
		.antMatchers("/produto/nome/{nome}").permitAll()
		.antMatchers(HttpMethod.GET,"/categoria").permitAll()
		.antMatchers(HttpMethod.GET,"/categoria/{id}").permitAll()
		.antMatchers(HttpMethod.GET,"/categoria/nome/{nome}").permitAll()
		.antMatchers("/categoria").permitAll()
		.antMatchers("/categoria/{id}").permitAll()
		.antMatchers("/categoria/nome/{nome}").permitAll()
		.anyRequest().authenticated().and().httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().cors().and().csrf().disable();
	}

}
