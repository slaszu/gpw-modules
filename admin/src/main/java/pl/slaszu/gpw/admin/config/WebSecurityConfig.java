package pl.slaszu.gpw.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.web.SecurityFilterChain;
import pl.slaszu.gpw.admin.oauth.CustomOAuth2UserService;
import pl.slaszu.gpw.admin.oauth.CustomOIDCUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/login_oauth").permitAll()
                .requestMatchers("/admin*").hasAuthority("ADMIN")
                .anyRequest().authenticated()
            )
            //.formLogin(withDefaults())
            .oauth2Login(httpSecurityOAuth2LoginConfigurer -> {
                httpSecurityOAuth2LoginConfigurer.loginPage("/login_oauth");
            });

        return http.build();
    }

    @Bean
    public DefaultOAuth2UserService getDefaultOAuth2UserService() {
        return new CustomOAuth2UserService();
    }

    @Bean
    public OidcUserService getDefaultOIDCUserService() {
        return new CustomOIDCUserService();
    }

//    @Bean
//    public DefaultLoginPageGeneratingFilter getDefaultLoginPage()
//    {
//        DefaultLoginPageGeneratingFilter defaultLoginPageGeneratingFilter = new DefaultLoginPageGeneratingFilter();
//    }

//        http
//            .authorizeHttpRequests((requests) -> requests
//                .requestMatchers("/").permitAll()
//                .anyRequest().authenticated()
//            )
//            .formLogin((form) -> form
//                .loginPage("/login")
//                .permitAll()
//            )
//            .logout((logout) -> logout.permitAll())
//            .oauth2Login().successHandler(new AuthenticationSuccessHandler() {
//
//                @Override
//                public void onAuthenticationSuccess(
//                    HttpServletRequest request,
//                    HttpServletResponse response,
//                    Authentication authentication
//                ) throws IOException, ServletException {
//
//                    Object principal = authentication.getPrincipal();
//
//                    //userService.processOAuthPostLogin(oauthUser.getEmail());
//
//                    response.sendRedirect("/list");
//                }
//            });
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//            User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}