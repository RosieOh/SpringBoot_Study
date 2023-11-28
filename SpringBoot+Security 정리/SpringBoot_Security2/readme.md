## Spring Security 기능 정리2

이 코드는 Spring Security를 사용하여 웹 애플리케이션의 보안 설정을 구성하는 방식입니다. WebSecurityConfigurerAdapter를 확장하고 @EnableWebSecurity 어노테이션을 사용하여 Spring Security를 활성화한 구성 클래스입니다.

주요 구성 내용은 다음과 같습니다:

> PasswordEncoder 및 UserService 주입:
- BCryptPasswordEncoder 및 UserService를 주입받아 사용합니다.

> DaoAuthenticationProvider 빈 설정:
- DaoAuthenticationProvider를 빈으로 등록하고, 사용자의 인증 처리 및 암호화를 위해 UserService와 BCryptPasswordEncoder를 설정합니다.

> configure(AuthenticationManagerBuilder auth) 메서드:
- AuthenticationManagerBuilder를 통해 사용자의 인증을 관리하는 authenticationProvider를 설정합니다.

> configure(HttpSecurity http) 메서드:
- HttpSecurity를 통해 HTTP 요청에 대한 보안 설정을 관리합니다.
- .authorizeRequests()를 사용하여 특정 URL 패턴에 대한 접근 권한을 설정합니다.
- permitAll()을 사용하여 모든 사용자에게 특정 URL에 대한 접근을 허용합니다.
- hasAuthority("ADMIN")를 사용하여 특정 URL에 대한 접근 권한을 ADMIN으로 제한합니다.
- authenticated()를 사용하여 나머지 모든 요청은 인증된 사용자에게만 허용됩니다.
- .csrf().disable().cors().disable()를 통해 CSRF 및 CORS 설정을 해제합니다.
- .formLogin()을 사용하여 로그인 페이지 및 성공, 실패 후의 동작을 설정합니다.
- .logout()을 사용하여 로그아웃 관련 설정을 합니다.
- .exceptionHandling()을 사용하여 예외 처리 페이지를 설정합니다.

이러한 구성을 통해 Spring Security를 통한 사용자 인증, 권한 관리, 로그인, 로그아웃 등을 설정하고 있습니다. 또한 특정 URL에 대한 권한이나 인증 여부를 확인하여 접근을 허용하거나 제한하고 있습니다.





