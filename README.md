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


#### 5.3 컨트롤러에 매개변수를 넣어준다면 ?  


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








