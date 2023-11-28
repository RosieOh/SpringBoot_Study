# 1.반영사항
- 스프링부트3 프로젝트
  - 스프링부트 : 3.1.1
  - 자바 : 17
  - 빌드 : maven
  - pom.xml 버전 정보가 많이 바뀌었습니다. 최신 pom.xml 버전을 참고하시기 바랍니다.
  - javax에서 jakarta로 변경됨에 따라서 많은 import 들이 jakarta로 수정되었습니다.
    - javax.validation => jakarta.validation
    - javax.persistence => jakarta.persistence
    - CustomAuthenticationEntryPoint.java (javax.servlet => jakarta.servlet)
    - Security 버전이 수정됨에 따라 기존 메소드가 deprecated 되었습니다.


> !HOTFIX : 이슈사항 : 스프링 부트 3.1.1 이후 버전 즉 오레오가 쓰는 3.1.6에서는 QDataResource가 부트에 내장됨에 따라 이 부분 조심
> 그리고 롬복도 지워야함

