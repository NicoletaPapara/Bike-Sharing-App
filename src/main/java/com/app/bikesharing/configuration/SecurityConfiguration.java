//package com.app.bikesharing.configuration;
//
//import com.app.bikesharing.service.LogInService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private LogInService logInService;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//    @Autowired
//    private DataSource dataSource;
//
//    private final String USER_QUERY = "select email, password, active from user where email=?";
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers(
//                        "/login**",
//                        "/js/**",
//                        "/css/**",
//                        "/img/**",
//                        "/webjars/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?logout")
//                .permitAll();
//    }
//
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl dataBase = new JdbcTokenRepositoryImpl();
//        dataBase.setDataSource(dataSource);
//
//        return dataBase;
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(userDetailsService());
//        auth.setPasswordEncoder(passwordEncoder());
//        return auth;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .usersByUsernameQuery(USER_QUERY)
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder);
//
//    }
//}
