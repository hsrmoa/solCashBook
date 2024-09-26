package com.cash.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// Security를 통해서 회원정보를 저장하고 회원가입하고, 그것을 검증할때에는 항상 비밀번호를 cash로 암호화시켜서
	// 검증해서 진행할때 암호화를 진행하는데 사용할수있음
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// csrf(이유? session방식에서는 세션이 고정되어있기때문에 csrf 공격을 방어해줘야함)
		http.csrf((auth) -> auth.disable());
		
		// FORM 로그인 방식을 disabled ==> JWT인증으로 쓸것이기때문에..
		http.formLogin((auth) -> auth.disable());
		
		// BASIC 로그인 방식을 diabled ==> JWT인증으로 쓸것이기때문에..
		http.httpBasic((auth) -> auth.disable());
		
		System.out.println("SECURITYCON");
		// 경로별 인가작업(특정경로에 대해서 어떠한 권한을 가져야하는지, 로그인을 해야하는지에대한 인가작업)
		// permitAll ==> 모두허용
		// hasRole ==> ADMIN 권한만
		// authenticated ==> 로그인한 사용자만 사용
		http
		.authorizeHttpRequests((auth) -> auth
				.requestMatchers("/loginCheck", "/", "/member/**").permitAll()
				.requestMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated());
		
		// 세션설정(중요한) 세션으로 STATELESS 상태로 관리..
		http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		return http.build();
	}
}
