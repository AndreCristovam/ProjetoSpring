package br.com.primeiroprojetospring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String INDEX_PATH_PRINCIPAL = "/principal";
	private static final String[] PUBLIC_MATCHERS = {"/h2-console/**", INDEX_PATH_PRINCIPAL};
	private static final String[] PUBLIC_MATCHERS_GET = {"/chave/**"};	
	private static final String LOGOUT_PATH_STRING = "/logout";
	
	
	protected void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll()
		.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()	
		.anyRequest().authenticated().and().formLogin().defaultSuccessUrl(INDEX_PATH_PRINCIPAL).permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher(LOGOUT_PATH_STRING));
	}
	
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/css/**","/js/**");
	}
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder enconder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("admin").password(enconder.encode("1234")).roles("ADMIN");
	}
}
