package com.company.courses.config;

import com.company.courses.model.User;
import com.company.courses.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.spi.EvaluationContextExtension;
import org.springframework.data.repository.query.spi.EvaluationContextExtensionSupport;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserService userService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(User.PASSWORD_ENCODER);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/fonts/**");
        web.ignoring().antMatchers("/img/**");
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/h2-console/**");
        web.ignoring().antMatchers("/api/v1/**");
        web.ignoring().antMatchers("/style.css");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/register").permitAll()
//                .anyRequest()
//                .hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .successHandler(loginSuccessHandler())
//                .failureHandler(loginFailureHandler())
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/login")
//                .and()
//                .csrf();

        http.authorizeRequests()
                .antMatchers("/").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//                .antMatchers("/userPage").access("hasRole('ROLE_USER')")
//                .antMatchers("/adminPage").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login");

    }

    public AuthenticationSuccessHandler loginSuccessHandler(){
        return (request, response, exception)->{
          response.sendRedirect("/");
        };
    }

    public AuthenticationFailureHandler loginFailureHandler(){
        return (request, response, exception)->{
//          request.getSession().setAttribute()
            response.sendRedirect("/login");
        };
    }

    @Bean
    public EvaluationContextExtension securityExtension(){
        return new EvaluationContextExtensionSupport() {
            @Override
            public String getExtensionId() {
                return "security";
            }

            @Override
            public Object getRootObject(){
                Authentication authentication =
                        SecurityContextHolder.getContext()
                        .getAuthentication();
                return new SecurityExpressionRoot(authentication) {
                };
            }
        };
    }
}
