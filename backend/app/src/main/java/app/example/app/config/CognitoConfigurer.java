//package app.example.app.config;
//
//import app.example.app.Cognito.CognitoAuthenticationEntryPoint;
//import app.example.app.Cognito.CognitoAuthenticationProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.authentication.AuthenticationProvider;
//
//public class CognitoConfigurer extends AbstractHttpConfigurer<CognitoConfigurer, HttpSecurity> {
//
//    private AuthenticationProvider authenticationProvider;
//    private AuthenticationEntryPoint authenticationEntryPoint;
//    private AccessDeniedHandler accessDeniedHandler;
//
//    @Autowired
//    public CognitoConfigurer(
//            CognitoAuthenticationProvider cognitoAuthenticationProvider,
//            CognitoAuthenticationEntryPoint cognitoAuthenticationEntryPoint,
//            CognitoAccessDeniedHandler cognitoAccessDeniedHandler
//    ) {
//        this.authenticationProvider = cognitoAuthenticationProvider;
//        this.authenticationEntryPoint = cognitoAuthenticationEntryPoint;
//        this.accessDeniedHandler = cognitoAccessDeniedHandler;
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .exceptionHandling()
//                .authenticationEntryPoint(authenticationEntryPoint)
//                .accessDeniedHandler(accessDeniedHandler)
//                .and()
//                .authenticationProvider(authenticationProvider);
//    }
//}