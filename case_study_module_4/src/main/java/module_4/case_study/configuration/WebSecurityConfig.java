package module_4.case_study.configuration;


import module_4.case_study.service.impl.MyUserDetailServiceImpl;
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
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
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

        http.csrf().disable(); //CSRF ( Cross Site Request Forgery) là kĩ thuật tấn công bằng cách sử dụng
        // quyền chứng thực của người sử dụng đối với 1 website khác

        // Các trang không yêu cầu login như vậy ai cũng có thể vào được admin hay user hoặc
        // guest có thể vào các trang
        http.authorizeRequests().antMatchers("/", "/home", "/login", "/logout").permitAll()
                .antMatchers("/customer").hasAnyRole("ADMIN", "MOD", "MEMBER", "USER")
                .antMatchers("/employee").hasAnyRole("ADMIN", "MOD", "MEMBER", "USER")
                .antMatchers("/service").hasAnyRole("ADMIN", "MOD", "MEMBER", "USER")
                .antMatchers("/contract").hasAnyRole("ADMIN", "MOD", "MEMBER", "USER")
                .antMatchers("/contractDetail").hasAnyRole("ADMIN", "MOD", "MEMBER", "USER")
                .antMatchers("/customer/**").hasAnyRole("ADMIN", "MOD")
                .antMatchers("/employee/**").hasAnyRole("ADMIN", "MOD")
                .antMatchers("/service/**").hasAnyRole("ADMIN", "MOD")
                .antMatchers("/contract/**").hasAnyRole("ADMIN", "MOD")
                .antMatchers("/contractDetail/**").hasAnyRole("ADMIN", "MOD")

        ;
//        .anyRequest().authenticated();


        // Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
        // Nếu chưa login, nó sẽ redirect tới trang /login.sau Mình dung hasAnyRole để cho phép ai được quyền vào
        // 2  ROLE_USER và ROLEADMIN thì ta lấy từ database ra cái mà mình chèn vô ở bước 1 (chuẩn bị database)
//        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
//
//        // Trang chỉ dành cho ADMIN
//        http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");

        // Khi người dùng đã login, với vai trò user .
        // Nhưng cố ý  truy cập vào trang admin
        // Ngoại lệ AccessDeniedException sẽ ném ra.
        // Ở đây mình tạo thêm một trang web lỗi tên 403.html (mọi người có thể tạo bất cứ tên nào kh
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/404");

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
                // Submit URL của trang login
                // url action đường dẫn từ form login
                .loginPage("/login") //Trả về view custom login, Nếu dùng method trên thì url để rỗng, nếu không có phương thức trên thì url phải mapping với action trong form login
                .defaultSuccessUrl("/home").permitAll()//đây Khi đăng nhập thành công thì vào trang này. userAccountInfo sẽ được khai báo trong controller để hiển thị trang view tương ứng
                .failureUrl("/login?error=true")// Khi đăng nhập sai username và password thì nhập lại
                .usernameParameter("username")//
                .passwordParameter("password")// tham số này nhận từ form login ở bước 3 có input  name='password'
                // Cấu hình cho Logout Page. Khi logout mình trả về trang
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/home");// Trả về trang home khi logout thành công

        // Cấu hình Remember Me. Ở form login bước 3, ta có 1 nút remember me. Nếu người dùng tick vào đó ta sẽ dùng cookie lưu lại trong 24h

        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(24 * 60 * 60); // 24h

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return memoryTokenRepository;
    }

}

