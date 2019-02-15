package ai.nexo.produtosapi.model.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableWebSecurity
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired()
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin").password("admin").roles("ROLE");
		
		//No Body informar
		// client - angular
		// username - admin
		// senha - admin
		//gran_type - password
		
		// recebo o access_token : "acked988304"
		//token_type : "bearer",
		// expires_in: 1799,
		// scope: "read write"
		
		//retorno no header
		// key - Authorization - value= bearer acked988304
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .antMatchers("/categorias").permitAll()
		    .anyRequest().authenticated()
		    .and()
		    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		    .csrf().disable();
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.stateless(true);
	}
}
