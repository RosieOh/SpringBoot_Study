# Spring Security 기능 정리1 .


이 코드는 Spring Security를 사용하여 웹 어플리케이션의 보안 설정을 구성한 것입니다. <br/>
Spring Security는 Java 기반의 웹 애플리케이션에 대한 보안 기능을 제공하는 프레임워크로, 사용자 인증, 권한 부여, CORS(Cross-Origin Resource Sharing) 설정, 세션 관리 등을 처리할 수 있습니다.

여기서 주요한 설정과 기능에 대한 설명을 제공하겠습니다:

> UserService 및 BCryptPasswordEncoder 빈 설정:
- UserService 및 BCryptPasswordEncoder를 빈으로 등록하였습니다. 
UserService는 사용자 정보를 가져오기 위한 서비스이고, BCryptPasswordEncoder는 비밀번호를 안전하게 암호화하기 위한 빈입니다.

> SecurityFilterChain 빈 설정:
- SecurityFilterChain은 Spring Security의 주요 구성 요소 중 하나로, HTTP 보안 구성을 정의합니다.
- authorizeRequests()를 사용하여 권한에 따라 URL에 접근하는 규칙을 설정합니다. 
- formLogin()을 사용하여 로그인 페이지, 로그인 처리 URL, 성공 후 리다이렉트 등을 설정합니다. 
- logout()을 사용하여 로그아웃 URL 및 로그아웃 성공 후 리다이렉트를 설정합니다. 
- sessionManagement()을 사용하여 중복 로그인 방지 등 세션 관리를 설정합니다.

> CORS 설정:
- CORS(Cross-Origin Resource Sharing)를 관리하기 위해 CorsConfigurationSource를 빈으로 등록하고, 허용할 오리진, 메서드, 헤더 등을 설정합니다.

> CSRF 및 CORS 방지 설정:
- http.csrf().disable().cors().disable()를 통해 CSRF(Cross-Site Request Forgery) 및 CORS 방지 설정을 해제하고 있습니다. 주로 개발 중에 불편함을 줄이기 위해 사용합니다.

> 세션 관리:
- 중복 로그인 방지 및 세션 관리를 위해 sessionManagement()을 설정하고, SessionRegistry와 HttpSessionEventPublisher를 빈으로 등록합니다.

> 로그인 및 로그아웃 URL 설정:
- 로그인 페이지, 로그인 처리 URL, 로그아웃 URL을 설정하고, 로그인 성공 후와 로그아웃 성공 후의 리다이렉트 URL을 정의합니다.

이렇게 Spring Security를 설정하면 웹 애플리케이션의 보안을 강화하고, 사용자의 권한에 따라 특정 URL에 접근을 제한할 수 있습니다. 또한 세션 관리 및 CORS 설정을 통해 웹 애플리케이션의 보안을 향상시킬 수 있습니다.
