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
import org.springframework.security.crypto.password.PasswordEncoder;

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
                .formLogin()
                .defaultSuccessUrl("/blog").permitAll()
                .and()
                .authorizeRequests().
                anyRequest().
                authenticated();

    }
}
