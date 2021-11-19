package com.codegym.configuration;


import com.codegym.service.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /* Cài đặt cách lấy thông tin UserDetail , cơ chế Encode password*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(myUserDetailService).passwordEncoder(bCryptPasswordEncoder());
    }
    /* Cấu hình security bằng http basic */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().disable(); Tắt security
        http.csrf().disable()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/home").permitAll()
                .and().exceptionHandling().accessDeniedPage("/404")
                .and()
                .authorizeRequests().antMatchers("/home").permitAll()
                .antMatchers("/customer").hasRole("ADMIN")
                .antMatchers("/member").hasRole("USER")
                .anyRequest().
                authenticated();

        //remember me
        http.authorizeRequests().and().rememberMe().
                tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(60*60*24);
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        InMemoryTokenRepositoryImpl memoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return memoryTokenRepository;
    }
}
