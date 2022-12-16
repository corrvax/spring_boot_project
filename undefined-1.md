# 스프링 부트에서 테스트 코드를 작성하자

## TDD

* RED : 항상 실패하는 테스트를 먼저 작성한다.
* GREEN : 테스트가 통과하는 프로덕션 코드를 작성한다.
* Refactor : 테스트가 통과하면 프로덕션 코드를 리팩토링합니다.



## 단위 테스트

기능 단위의 테스트 코드를 작성하는 것

TDD와 달리 테스트 코드를 꼭 먼저 작성해야 하는 것도 아니고, 리팩토링도 포함되지 않습니다.

순수하게 테스트 코드만 작성하는 것을 이야기한다.



## 단위 테스트 장점

* 단위 테스트는 개발단계 초기에 문제를 발견하게 도와줍니다.
* 단위 테스트는 개발자가 나중에 코드를 리팩토링하거나 라이브러리 업그레이드 등에서 기존 기능이 올바르게 작동하는지 확인할 수 있습니다.(회귀 테스트)
* 단위 테스트는 기능에 대한 불확실성을 감소시킬 수 있습니다.
* 단위 테스트는 시스템에 대한 실제 문서를 제공합니다. 즉, 단위 테스트 자체가 문서로 사용할 수 있습니다.



## 테스트 코드의 장점

1. 테스트 코드는 매번 코드를 수정할 때마다 톰켓을 내렸다 다시 실행할 필요가 없습니다.
2. 출력 결과를 확인하지 않고, 사람이 눈으로 검증하지 않게 자동검증이 가능합니다.
3. 개발자가 만든 기능을 안전하게 보호합니다.(테스트 코드는 하나의 기능을 추가할 때마다 모든 기능을 테스트하지 않고 기존 기능이 잘 작동되는 것을 보장해줍니다.)

\--> 이러한 테스트 코드 작성을 도와주는 JUnit 프레임워크를 사용합니다.



<table><thead><tr><th>@SpringBootApplication</th><th>SpringApplication.run</th><th data-hidden></th></tr></thead><tbody><tr><td>스프링 부트의 자동 설정, 스프링 Bean읽기와 생성을 모두 자동설정</td><td>내장 WAS를 실행->톰캣 설치할 필요 없이 Jar파일(실행가능한 java 패키징파일)로 실행하면됨</td><td></td></tr><tr><td>프로젝트의 최상단에 위치해야 함</td><td>스프링부트 내장 WAS를 사용하면 언제 어디서나 같은 환경에서 스프링 부트를 배포가능함</td><td></td></tr></tbody></table>



## 테스트 코드 오류

Execution failed for task ':test'.

> There were failing tests. See the report at: file:///Users/EunJoKim/spring\_boot\_project/build/reports/tests/test/index.html

<figure><img src=".gitbook/assets/스크린샷 2022-12-10 오후 11.51.45.png" alt=""><figcaption></figcaption></figure>

IntelliJ IDEA > Preferences > Build,Execution,Deployment > Gradle > Run test using : IntelliJ IDEA

<figure><img src=".gitbook/assets/스크린샷 2022-12-10 오후 11.57.47.png" alt=""><figcaption></figcaption></figure>

### @RunWith(SpringRunner.class)

테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킵니다.

여기서는 SpringRunner라는 스프링 실행자를 사용합니다.

즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 합니다.

### @WebMvcTest

여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션입니다.

선언할 경우 @Service, @Component, @Repository 등은 사용할 수 없습니다.&#x20;

여기서는 컨트롤러만 사용하기 때문에 선언합니다.

### @Autowired

스프링이 관리하는 빈(Bean)을 주입 받습니다.

```
private MockMvc mvc
```

웹 API를 테스트할 때 사용합니다.

스프링 MVC 테스트의 시작점입니다.

이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있습니다.

```
mvc.perform(get("/hello"))
```

MockMvc를 통해 /hello 주소로 HTTP GET 요청을 합니다.

체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있습니다.

```
.andExpect(status().isOk())
```

mvc.perform의 결과를 검증합니다.

HTTP Header의 Status를 검증합니다.->200,404,500 등의 상태를 검증합니다.

여기선 OK(200)인지 아닌지를 검증합니다.

```
.param("name",name)
```

API 테스트할 때 사용될 요청 파라미터를 설정합니다.

단, 값은 String만 허용됩니다. -> 숫자/날짜 등의 데이터는 문자열로 변경해야만 합니다.
