package com.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
        .antMatchers("/loginForm").permitAll()
        .anyRequest().authenticated();

    	http.formLogin()
        .loginProcessingUrl("/login")
        .loginPage("/loginForm")
        .usernameParameter("email")
        .passwordParameter("password")
        .defaultSuccessUrl("/library", true)
        .failureUrl("/loginForm?error");

    	http.logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/loginForm");


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        /** 以下のファイルパス配下のディレクトリ、ファイルすべてを認証・認可の対象から除外します
            src/main/resources/static/css/
            src/main/resources/static/js/
            src/main/resources/static/images/
        */
        web.ignoring().antMatchers("/css/**", "/js/**");

    }

}
