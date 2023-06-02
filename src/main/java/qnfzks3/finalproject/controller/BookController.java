

package qnfzks3.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import qnfzks3.finalproject.model.Book;
import qnfzks3.finalproject.service.BookService;

import java.util.List;


/* 1번 컨트롤러 방식 */
/*

@Controller
public class BookController {

    @Autowired
    private BookService bookService;  //service 객체로 접근 하도록 한다.

    @RequestMapping(value = "/booklist", method = RequestMethod.GET) //주소창 마지막에 /booklist경로로 입려되면 get요청되어  아래 requestBookList가 실행된다.
    public String requestBookList(Model model){ //Model 객체 사용
        List<Book> allbooklist = bookService.getAllBookList();  //requestBookList가 실행 되면 위에서 @Autowired 어노테이션을 통해 주입바은 bookService안에 getAllBookList를 list로 호출
        model.addAttribute("bookList",allbooklist);
        // addAttribute는 웹 요청을 처리할 메서드 - 위에 정의한 Model model로 bookList라는 속성 이름으로 list 데이터를 추가하는 역할 ,

        return "list/booklist"; //이렇게 컨트롤러에서 조회한 책 목록 데이터를 모델에 추가하여 booklist라는 이름의 뷰로 전달한다.
    }
}
*/


/*2번 컨트롤러 방식 - 주소창에 http://localhost:8080/books/all 경로로 만들기- 기본 매핑 설정*/

@Controller
@RequestMapping("/books")    //기본 매핑을 설정 하고
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/all") //똑같이 /all 경로에 요청 메서드 실행
    public String requestBookList(Model model) { //Model 객체 사용
        List<Book> allbooklist = bookService.getAllBookList();
        model.addAttribute("bookList", allbooklist);


        return "list/booklist";

    }
}

