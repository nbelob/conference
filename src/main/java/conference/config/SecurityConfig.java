package conference.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;

    @Autowired
    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                    .loginPage("/login")
                .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/account/register").permitAll()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/h2-console/**").permitAll()  // Allow H2 Database Console
                    .anyRequest().authenticated();

        // Allow H2 Database Console, http://localhost:8080/h2-console
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, true from account where username = ?")
                .authoritiesByUsernameQuery("select username, 'ROLE_USER' as authority from account where username = ?")
                .groupAuthoritiesByUsername("select 1 as id, 'GROUP_NAME' as group_name, 'ROLE_USER' as authority from account where username = ?")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
