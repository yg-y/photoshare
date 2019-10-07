package com.photoshare.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//       /* http.
//                csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint(new Http401AuthenticationEntryPoint("Bearer realm=\"webrealm\""))
//                .and()
//                .authorizeRequests().anyRequest().authenticated()
//                .and()
//                .httpBasic();*/
//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.NEVER)
//                .and()
//                .requestMatchers()
//                .antMatchers("/**")
//                .and()
//                .authorizeRequests()
//                .filterSecurityInterceptorOncePerRequest(true)
//                .antMatchers("/api/**").permitAll()
//                .and().headers().frameOptions().disable();
//    }
}

