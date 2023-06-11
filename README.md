# myfinalproject 개인 연습

## 환경 MVC (Model-View-Controller) 
-- Model(데이터 타입,데이터) , View (사용자 인터페이스) ,Controller(모델과 뷰를 조정)

--pom에서 환경 세팅 - 주의점! 경로는 언제나 고정된 이름이어야 한다.
* apathe tomcat 9.0.74
* jakarta EE (maven)

* mapper - 데이터베이스와 서로 상호작용 하기위한 파일이다.



* mybatis - 데이터베이스와 연동하는 mapper파일 sql의 결과 값을 mybatis의 SqlSession객체를 이용해
            데이터를 출력하는 용도로 사용된다. 
          즉,SQL 매핑 파일에 SQL문을 직접 작성하여 데이터베이스에 접근하고, 결과를 매핑하여 자바 객체로 변환


 

* mariadb -서버(데이터베이스 시스템)

* log4j2 -로그 메시지를 사용

* web - serverlet , Spring Web MVC
web은 web.xml 파일로 항상 src/main/webapp/WEB-INF 폴더에 위치해야 한다.
web.xml 파일은 요청 URL과 해당하는 서블릿 또는 필터의 매핑을 정의한다.
web.xml 파일에 오류에 대한 처리 방법을 설정한다. => Redirect 같은 오류 페이지도 이 파일에서 수행할 수도 있다.

* JSTL - 웹 애플리케이션의 프론트엔드와 백엔드를 연결하는 역할을 수행 - JSTL

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>'

   인터페이스(html,jsp)에 c: 테그로 구현하여 다룬다.

* JSON - JSON형식으로 보통 데이터를 교환한다. 이유는 데이터 저장 및 전송 효율적이며 데이터 구조를 다른 플렛폼에서도 쉽게 처리가능 
jackson-core, jackson-databind 를 POM에 추가

* bootstrap  - 인터페이스를 더 간단하게 제작가능하도록 도와줌

* tiles  -  중복된 인터페이스 사용을 도와줌

* bean  - 특정 규칙을 따르는 Java 객체 , 또한 beans는 bean의 복수형 형태로 사용, 여러 개의 Bean 객체를 나타낸다.
  설정 파일이나 애노테이션(@)을 통해 정의된 Beans를 생성하고 관리 



* @PathVariable("변수") =  변수를 경로로 지정하게 해주는 함수 /변수
* @RequestParam("다른 변수명")  = 컨트롤러엔 변수명을cpg라고 적으면 위에 ?로 시작해서 cpg= 로 변수가 나오는게
                                아니라 다른 변수명= 로 나오게 보안상등의 이유로 변수를 가릴수 있도록 하는 함수



* 질의 문자열이란?
웹서버에 정보를 요청할때 정해진방식으로 전달하는 데 이때 사용하는 문자열을 질의 문자열이라한다.
질의 문자열의 전송 규칙이있는데, 
1.이름을 value형식으로 전달되며, 여러개의 value값(매개변수같은)이 존재할때는 순서와 상관없이 &를 구분자로 사용한다.
   예)id=guset&name=Army
2.영문자, 숫자, 일부 특수문자는 그대로 전달되고 , 이를 제외한 나머지 문자는 %기호와 함깨 16진수로 바뀌어 전달된다.
예)주소창을 복사 붙여넣기 하면 EC%84%9C과 같이 나오는 이유

3.공백 문자는 +기호로 변경되어 전달된다.
예)id=guest&name=Jhon+Smith

4.주소창에 적을 시  변수들은 ?뒤로 fkey=1 과 같이 나오는 질의문은 param으로 가져오며 , 앞에 /booklist같은 
경로는 param없이 그냥 사용해준다.


* 바인딩 - 변수에 값을 받아오는 것을 말함
         주소창의 질의 문자열에 해당하는 문자열 값이 컨트롤러에서 매개변수 값으로 받아옴-(바인딩)
         컨트롤러에서 매퍼로도 #{}를 사용해서  바인딩함 


  

5/30일 - 시작

목표 - 책 보고 환경 설정 하기, 왜 이 환경을 세팅했는지 이해하기 

기획 순서
### 1. 생성 시작 - 인텔리제이로 jakarta로 servlet만 추가해서 생성 했다. 


### 2. 환경 설정 파일을 만들어 보자! 

(1) web.xml 파일 만든다.   (지시자 파일) - 구성과 설정 담당
 web.xml 파일은 웹브라우저의 웹 요청 URL을 전달 받는다.
 - 이렇게 URL로 root-context와 servlet-context.xml의 경로를 지정하여 MVC의 설정 파일들을 정의한다.
 
 web.xml파일에 설정된 서블릿이 클라이언트의 웹 요청 URL을 제어 한다. - 주소로 매핑등 하려면 이게 정의되어있어야한다.
 - 공통 사항- 서로 bean객체를 정의하는 파일이지만

 - root-context 설정- 주로 view를 제외한 나머지 내부 시스템 설정 
    데이터베이스 연결 설정,서비스 레이어,레퍼지토리,트랜잭션 관리 설정,session,mybatis, 보안 설정 등 
    bean을 설정하는데 사용 - 파일 안에 부가 기능정도 설정
    전역(root)으로 모든 서블릿과 필터에 사용되는 bean 객체 정의하고 공유하는 역할

 - servlet-context 설정- 서블릿 컨텍스트 파일로 DispatcherServlet에 의해 로드 되는데,
  웹 관련 설정 - 담당 웹과 상호작용 할 때(selvlet)의 설정
  그냥 servlet 담당 컨트롤러, 뷰(view) 리졸버, 리소스 핸들러, 폼 처리 등과 관련된 빈 객체를 정의
  뷰를 어떻게 처리할지 설정. 즉,  beans 들을 애노테이션으로 어떻게 작동시킬지 설정
 

 - pom에서 web 관련된 것들을 추가해주자


(2) root-context와 servlet-context를 만들자
 servlet은 주소로 이동하거나 



 - root-context ,servlet-context 를 만들 때 만약 필요하다면 pom에도 같이 적어주자 


### 3. 환경 세팅- pom세팅을 해보자  -- pom.xml파일에 적은 주석 설명 확인바람
* dependence는 의존성이라는 뜻  
* <properties> 속성 정보</properties>
* <dependence> 의존성 라이브러리 정보 </dependence>
  
  <dependency>
    <groupId>그룹 ID</groupId>
    <artifactId>아티펙트 ID</artifactId>
    <version>버전</version>
    <scope>범위</scope>
  </dependency>




### 4. 이제 시작해보자 
JSP는 Java 코드와 HTML을 혼합하여 동적인 웹 페이지를 생성하는 데 사용되는 템플릿 엔진
* jsp 파일 과 css 로 웹 화면을 디자인 해보자

* 다 되었다면 마리아 db와 연동을 해보자 
  마리아 db와 연동하기 위해 이전에 pom에서 mariadb 드라이버와 dbcp2 를 넣어 줬을 것이며,
  mybatis(세션), mapper(데이터베이스 sql문으로 제어)도 적어주었고 
  jdbc (데이터베이스 연동을 스프링 프레임워크에서 편리하게 사용할 수 있도록 지원) 을 적어 주었다.
  (여긴 파일만 생성한 root-context에 이제 내용을 적어주자 - dbcp로 연결 데이터베이스 연결)
                                                  - mybatis의 session 설정 
 이제 mvc- model service controller로 넘어가보자

* 먼저 데이터베이스의 컬럼들의 타입(model)을 만들어보자

* 다 만들었다면 이제 dao(Repository-함수 만들고)를 만들어서 
   daoImpl(@Repository - dao이름 정의)을 만든다.
   이제 **mapper파일을 만든 후 안에 우리가 가져오고 싶은 데이터가 있는 테이블에 sql문으로 데이터를 가져온다. 
   daoImpl에는 mapper로 가져온 데이터를 출력 시킨다.

  service로 이 데이터들을 컨트롤러에 출력 시켜준다 - 여기서는 이 데이터들이 조건부로 출력될 수 있도록 만들어줄수있음
  조건 if 등으로 그후 컨트롤러로 jsp 파일에 세션에 담아 보낼 수 있다.
  
* 이제 컨트롤러로 getmapping 을 써서 가져오고 postmapping로 보내거나   둘로 나누기 싫다면 RequestMapping 를 어노테이션으로 사용해서
  컨트롤러로 만들고 뷰로 보내자


### 5.컨트롤러

#### 5.1  RequestMapping,GetMapping 과 PostMapping ,
*  RequestMapping - 수행하는 역할은 GetMapping과 같은 역할을 수행하지만 실행하는 과정이 다르다.
                    RequestMapping는 ModelAndView사용 불가 
                    아래 5.2 참고

* GetMapping  - 매핑할 HTTP 요청 방식이 GET
        
        @GetMapping("/booklist")
        public ModelAndView requestBookList(Model model) { 
        ModelAndView mv = new ModelAndView();
        List<Book> allbooklist = bookService.getAllBookList();
        mv.addObject("bookList", allbooklist); 
        mv.setViewName("list/booklist");

        return mv;
        }
GetMapping은 데이터를 담을 그릇으로 Model과 ModelAndView를 사용할 수 있다.
보통 GetMapping은 주소창 경로로 이동하면 내용이 실행된다. - 위에선 dao(mapper에서 가져온 데이터)와 
    service(데이터 출력에 조건을 붙여서 넘어온)를 가지고 모델이나 모델엔뷰 라는 저장 공간에 넣어주고 
    뷰(list/booklist)로 보내는 역할


* PostMapping - service에서 조건을 보통 거는데 이 조건(인풋창을 공백으로 뒀을 때 같은)들을 충족하지 않는다면,
                같은 주소라도 오류를 출력해야한다. 이럴 때 처럼 같은 주소 /booklist 에서 에러가 나왔을 때
                다음 페이지 뷰(list/bookinfo) 페이지로 보내는게 아니라 
                다시 다음 페이지로 안넘어가게하고 같은 뷰(list/booklist) 페이지로 나오게 할 수 있다.
                또한 이걸 이용해서 조건에 따라 다른 페이지로 보내는것이 가능하다.



#### 5.2 ModelandView 클라스와 Model 클래스(ModelMap)에 대해 알아보자! - RequestMapping 사용하지않을 경우

* Model         - 뷰에 사용할 데이터 addAttribute() 사용해서 데이터를 넣어준다 ,
                   요청할 뷰 이름을 리턴으로 지정해서 값을 보낸다.

* ModelandView  - addObJect() 를 사용해서 데이터를 넣어준다 ,
                    요청할 뷰 이름을 set


#### 5.3 컨트롤러에 매개변수를 넣어준다면 ?  매개 변수가 곧 경로 변수가 된다.


    @GetMapping("/booklist")
    public ModelAndView requestBookList(int cpg) { //ModelAndView 객체 사용
        ModelAndView mv = new ModelAndView();

        mv.addObject("bookList", bookService.getAllBookList(cpg)); //뷰 파일(jsp)로 보낼 데이터를 booklist라는 ModelAndView에 이름으로 넣어줌
        mv.setViewName("list/booklist");

        return mv;

        }
    }

이렇게 컨트롤러에 매개변수(int cpg)를 넣어 준다면 ?? 컨트롤러의 매개변수는 주소창에서 ?cpg=1 로 불러와진다.
http://localhost:8080/books/booklist?cpg=1 로 검색창에 치면 cpg에 매개변수 값은 1 로 지정되어 
controller - > service - > repository - > mapper 로 전해지게 하여 페이지 네이션의 작동 원리가 된다.

-> 매개변수를 여러개 써줄때는  ? 뒤로 순서 관계없이 cpg=1&category=book 이런식으로 써주면 된다. 



#### 5.4  @PathVariable 경로변수 - 경로에서 가져오는 변수

    @Controller
    @RequestMapping("/home")
    public class 매서드 이름 {
    
        @GetMapping("/exam01/{bookid}")
        public String requestMethod(@PathVariable String bookid , Model model){
            model.addAttribute("data","도서 ID:"+bookid);
            return "webpage06";
        }
    }
이 경우 , http://localhost8080/home/exam01/ss123 이면 
@RequestMethod()에서 @PathVariable이 설정된 매개 변수 bookid가 경로 변수의 값인 ss123이 된다.
여기서 경로변수를 두개 써서 가져오고 싶다면

    @GetMapping("/exam01/{bookid}/{writer}")
    public String requestMethod(@PathVariable String bookid,@PathVariable String writer , Model model){
        ...
    }
이렇게 @PathVariable를 두번 적어주고 가져오면 된다.






mapper에 sql문에 쓸 경우
$를 사용하는 경우, 
해당 위치에 매개변수 값을 그대로 문자열로 치환합니다. 
이는 SQL 쿼리에 직접 값을 삽입하는 것과 유사합니다. 
하지만 이렇게 사용할 경우 SQL Injection과 같은 보안 문제가 발생할 수 있으므로 주의해야 합니다.

#를 사용하는 경우, 
해당 위치에 매개변수 값을 치환하는 것이 아니라 JDBC에서 제공하는 PreparedStatement 기능을 사용하여 값을 바인딩합니다.
이 방식은 매개변수 값을 안전하게 처리할 수 있으며 SQL Injection을 방지할 수 있습니다.

$를 #로 사용해도 문제는 없다. - 하지만 가능하면 #를 써서 적어주도록 하자

parameterType은 컨트롤러에서 서비스 dao등 거처서 올 매개변수의 타입을 적어준다. 이때 매개변수의 타입이
스트링이고 테이블의 타입이 int 라도 #{}를 사용하여 매개변수를 가져오면 자동으로 형 변환이 되기 때문에 sql 사용가능
ex)where bookid = ${bookid}
          int    String->int


#### 6. 이제 데이터를 출력하고 페이지네이션을 만들어 보자!
 * 우선 데이터를 개수에 맞게 출력해보자
   Integer cpg,@PathVariable("category") String bookCategory, String fkey를 
   컨트롤러의 매개변수로 사용해주었다. 
   cpg는 현재 페이지를 알려주기위해
   bookCategory는 카테고리가 뭔지
   fkey는 검색어 
   매개 변수로 사용했을 시 http://localhost:8080/books/booklist?cpg=1&fkey=교과서 나
   http://localhost:8080/books/booklist?fkey=교과서&cpg=1 나 순서는 상관 없다. 
    
   또한, 여러개의 매개 변수를 사용할 시(mapper에 #{}로 가져온 매개변수가 여러개일 때),
   Map<String, Object> params = new HashMap<>();같이 
   map으로 변수들을 넣어줘서 출력해주자.
   그렇게 dao로 넘겨주고 mapper로 변수로 넘겨준다.
 
   dao에서는 mybatis의 sqlSession.   (selectOne,selectList)로 mapper에서 sql문으로 출력되는 
    컬럼들을 가져올 수 있다. 

   selectOne는 단일 데이터 한 행 또는 한 칼럼의 값일 때 사용
   selectList는 다수의 데이터를 가져올 때 사용한다.
   
(booklist)
페이지 네이션 정리 = 페이지 네이션 1. jsp에는 그냥 주소로 이동하도록 for와 <a>태그를 이용해서 페이지를 나타낸다.
                                  주소가 고정 될 수 있도록
<c:set var="pglink" value="/list/booklist/${category}?fkey=${param.fkey}&cpg=" />를 적어줘서 
for로 데이터수만큼 i 에 들어가게 한다.

이제 컨트롤러를 만들어 보자 
컨트롤러는 주소의 cpg 값을 받아와서 이걸 controller - > service -> dao ->mapper 로 보내고
sql을 mapper -> dao ->service->controller 로 받아와 jsp에 출력할 수 있도록 한다.



#### 7. jsp에서 데이터를 컨트롤러로 어떻게 가져올지 와 컨트롤러의 경로에 대해 알아보자

* @ModelAttribute - jsp에서 form으로 참조하는 커맨드 객체를 적어주고,
                    컨트롤러에 설정된 객체와 동일한 이름으로 설정하여,그 객체로 서로 데이터 바인딩 및 모델 초기화 역할, 
                    PostMapping이 어노테이션으로 바인딩 된 데이터들을 사용할 수 있게 한다.
                    GetMapping에서이 어노테이션으로 바인딩 된 데이터들을 초기화  

* @InitBinder  - 데이터 바인딩 설정을 초기화하거나 커스터마이즈하는 용도로 사용
                  주로 데이터 변환, 검증, 바인딩 설정 등을 처리하는데 사용한다.
                  @InitBinder 메서드는 WebDataBinder 객체를 파라미터로 받고 ,초기화 한다.
                  @GetMapper위치에 @InitBinder , @ModelAttribute이 있는 위치에 WebDataBinder사용
  


#### 8. 로그인/로그아웃 - 스프링 시큐리티 

* 스프링 시큐리티는 인증, 권한 부여를 관리하는 유틸리티를 제공

1. 인증(Authentication): 스프링 시큐리티는 다양한 인증 방식을 지원합니다. 
 사용자의 아이디와 비밀번호를 사용한 폼 기반 인증, OAuth, OpenID, SAML 등의 인증 프로토콜을 지원
 인증된 사용자는 보호된 자원에 접근할 수 있습니다.

2. 권한 부여(Authorization): 스프링 시큐리티는 애플리케이션의 자원에 대한 접근 권한을 관리합니다. 
개발자는 세밀한 수준에서 권한을 정의할 수 있으며, 
애노테이션 기반의 접근 제어, URL 기반의 접근 제어, 메서드 수준의 접근 제어 등 다양한 방식을 사용할 수 있습니다.

3. 보안 설정: 스프링 시큐리티는 보안 설정을 편리하게 처리할 수 있도록 도와줍니다. 
XML 또는 자바 기반의 설정을 사용하여 보안 정책을 구성할 수 있으며, 강력한 보안 기능을 지원합니다.

4. 세션 관리: 스프링 시큐리티는 세션 관리를 지원하여 사용자의 로그인 상태를 유지하고, 세션 공격으로부터 보호할 수 있습니다.

5. 암호화: 스프링 시큐리티는 사용자의 비밀번호를 안전하게 저장하기 위해 암호화 기능을 제공합니다. 
 주로 해시 함수를 사용하여 비밀번호를 저장하고 검증합니다.

6. 로그인/로그아웃 처리: 스프링 시큐리티는 로그인과 로그아웃을 처리하는 기능을 제공합니다. 
7. 로그인 폼, 인증 성공/실패 처리, 로그아웃 등의 작업을 간편하게 구현할 수 있습니다.


* pom.xml에 의존 라이브러리 등록: spring-security-web.jar을 spring-security-config.jar과 함께 pom.xml에 추가

        
- spring-security-web.jar : 필터 및 웹 보안 인프라 관련 코드를 포함한다.-스프링 시큐리티 웹 인증 서비스 및 url기반
                            엑세스를 제어하는 경우에 필요한 모듈 

        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-web</artifactId>
            <version>5.6.3</version>
        </dependency>

- spring-security-config.jar : 보안 네임 스페이스 구문을 분석하는 코드 
                                - 구성을 위해 스프링 시큐리티 xml네임 스페이스를 사용하느 경우 필요한 모듈

        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-config</artifactId>
            <version>5.6.3</version>
        </dependency>



* web.xml 파일에 시큐리티 필터,설정 파일 등록하기 

-필터 등록

        <filter>
            <filter-name>springSecurityFilterChain</filter-name>
            <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
        </filter>
    
        <filter-mapping>
            <filter-name>springSecurityFilterChain</filter-name>
            <url-pattern>/*</url-pattern>
        </filter-mapping>

- 설정 파일 등록 - classpath 파일 경로 사용

        <context-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring/root-context.xml
            classpath:spring/security-context.xml
            </param-value>
        </context-param>


- security-context 에 이제 관리자를 지정해보자 (java/resources/spring/servlet-context) 파일을 확인해보자

        <http use-expressions="true"> <!--시큐리티의 시작과 끝을 나타내는데 사용함-->
        <intercept-url pattern="/list/add" access="hasAuthority('ROLE_ADMIN')"/> <!--시큐리티가 적용되는 URL를 지정-->
        <form-login/> <!--로그관련 설정을 하는 데 사용한다.-->
        <csrf/>  <!-- 보안 -->
        <logout/> <!--로그아웃 관련 설정-->

        <!--관리자 지정 -->
        </http>
        <authentication-manager> <!--사용자 권한을 위한 최상위 태그-->
            <authentication-provider> <!--사용자 정보 인증 처리-->
                <user-service> <!--유저 정보를 가져올 때 사용-->
                    <user name="admin" password="{noop}admin" authorities="ROLE_ADMIN"/> 

                </user-service>
            </authentication-provider>
        </authentication-manager>

- 권한 지정

    ROLE_ADMIN 관리자
    ROLE_USER 일반 사용자
    ROLE_ANONYMOUS 모든 사용자
    ROLE_RESTRICTED 제한된 사용자
    IS_AUTHENTICATED_FULLY 인증된 사용자
    ROLE_AUTHENTICATED_ANONYMOUSLY 익명 사용자
    ROLE_AUTHENTICATED_REMEMBERED  REMEMBERED 사용자
  


-   {noop}은 암호화 하지 않겠다 선언-현장에선 암호화 적용해야함
    

* 암호화를 하기 위해선 security-context.xml에 PasswordEncoder 빈 등록 , 컨트롤러와 레퍼지토리도 만들어주어야함
       <beans:bean id="passwordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder" />
  
    -- 나중에 암호화 하는법 알아보기 - 지금은 그냥 {noop}사용해서 암호화 하지 않고 그냥 씀



* 뷰 페이지에 사용하는 시큐리티 태그 

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 설정을 주고 시작

<sec:authorize> 권한 태그
- access 접근 권한 설정을 위한 정규 표현식
- url 접근 권한 사용자만 접근 하도록 경로를 설정
- var 접근 권한 설정된 사용자를 변수로 재정의 하여 설정


-> <sec:authorize access="hasRole('ROLE_ADMIN')" var="권한된 이름"> ...</sec:authorize> 사용자 권한 가짐

-> <sec:authorize access="!hasRole('ROLE_ADMIN')" var="권한된 이름"> ...</sec:authorize> 사용자 권한 가지고있지 않음

-> <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANGER')"> ...</sec:authorize> 사용자가 둘중 하나의 권한을 가질 때

-> <sec:authorize access="isAuthenticated()"> ...</sec:authorize> 사용자가 로그인 할 때

-> <sec:authorize access="isAnonymous()"> ...</sec:authorize> 사용자가 로그인을 하지 않을 때




