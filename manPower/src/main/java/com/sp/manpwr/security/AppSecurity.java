package com.sp.manpwr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {

	// private final Logger logger = LoggerFactory.getLogger(AppSecurity.class);

	private static String REALM = "MY_TEST_REALM";
	// private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public AppSecurity() {
		super();
	}

	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.eraseCredentials(false);
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder()).and()
				.authenticationProvider(authenticationProvider());

	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		// @formatter:off
		http.authorizeRequests().antMatchers("/login*", "/register-user/*", "/*").permitAll()
				.antMatchers("/register/*", "/admin/**").hasAuthority("ROLE_ADMIN").antMatchers("/user/*", "/user/**")
				.hasAuthority("ROLE_USER").antMatchers("/admin/unauthorized-access*").anonymous().and().formLogin()
				.loginPage("/login").usernameParameter("email").passwordParameter("passWord").defaultSuccessUrl("/register")
				// .successHandler(myAuthenticationSuccessHandler())
				.failureUrl("/unauthorized-access").permitAll().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).invalidSessionUrl("/session-inactive")
				.maximumSessions(2).sessionRegistry(sessionRegistry()).and().sessionFixation().none().and().csrf()
				.ignoringAntMatchers("/rest/**").and().authorizeRequests().antMatchers("/rest/**").permitAll()
				.antMatchers("/rest/admin/**").hasAnyRole("ADMIN", "USER").antMatchers("/rest/newOrder").permitAll()
				.and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint()).and().logout()
				.invalidateHttpSession(true).logoutUrl("/logout").logoutSuccessUrl("/").deleteCookies("JSESSIONID")
				.permitAll().and().exceptionHandling().accessDeniedPage("/unauthorized-access");
		// @formatter:on
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	/*
	 * @Bean public LogoutSuccessHandler logoutSuccessHandler() { return new
	 * CustomLogoutSuccessHandler(); }
	 * 
	 * @Bean public AccessDeniedHandler accessDeniedHandler() { return new
	 * CustomAccessDeniedHandler(); }
	 */
	/*
	 * @Bean public AuthenticationFailureHandler authenticationFailureHandler() {
	 * return new CustomAuthenticationFailureHandler(); }
	 */

	@Bean
	public RestAuthenticationEntryPoint getBasicAuthEntryPoint() {
		return new RestAuthenticationEntryPoint();
	}

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}

}
