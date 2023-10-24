package AppLetsLearnEnglish.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import AppLetsLearnEnglish.Service.AccountService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SercurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
//	@Autowired
//	private JWTTokenHelper jwtTokenHelper;
//	@Autowired
//	private AuthenticationEntryPoint authenticationEntryPoint;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		//***************************VIEWS ROLES****************************//
		.antMatchers("/**").permitAll();
//		.antMatchers("/rest/**").authenticated()
//		//***************************ADMIN ROLES****************************//
//		.antMatchers("/admin/**").hasAnyAuthority("ADMIN")
//		//***************************USER ROLES****************************//
//		.antMatchers("/user/**").hasAnyAuthority("USER")
//		.anyRequest().permitAll()
//		.and()
//		.formLogin().permitAll();
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
//		.authenticationEntryPoint(authenticationEntryPoint).and()
//		.authorizeRequests((request) -> request.antMatchers("/h2-console/**", "/api/v1/auth/login").permitAll()
//				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated())
//		.addFilterBefore(new JWTAuthenticationFilter(userDetailsService, jwtTokenHelper),
//				UsernamePasswordAuthenticationFilter.class);
	}
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
}
