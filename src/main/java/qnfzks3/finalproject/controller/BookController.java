

package qnfzks3.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import qnfzks3.finalproject.model.Book;
import qnfzks3.finalproject.service.BookService;

import java.io.File;
import java.util.List;


/* 1번 컨트롤러 방식 */
/*

@Controller
public class BookController {

    @Autowired
    private BookService bookService;  //service 객체로 접근 하도록 한다.

    @RequestMapping(value = "/booklist", method = RequestMethod.GET) //주소창 마지막에 /booklist경로로 입려되면 HTTP get요청되어  아래 requestBookList가 실행된다.
    public String requestBookList(Model model){ //Model 객체 사용
        List<Book> allbooklist = bookService.getAllBookList();  //requestBookList가 실행 되면 위에서 @Autowired 어노테이션을 통해 주입바은 bookService안에 getAllBookList를 list로 호출
        model.addAttribute("bookList",allbooklist);  //뷰 파일에 보낼 데이터
        // addAttribute는 웹 요청을 처리할 메서드 - 위에 정의한 Model model로 bookList라는 속성 이름으로 list 데이터를 추가하는 역할 , model은 단순히 저장공간같은거

        return "list/booklist"; //이렇게 컨트롤러에서 조회한 책 목록 데이터를 모델에 추가하여 booklist라는 이름의 뷰로 전달한다.
    }
}
*/




/*2번 컨트롤러 방식 - 주소창에 http://localhost:8080/books/booklist 경로로 만들기- 기본 매핑 설정*//*

/*
@Controller
@RequestMapping("/books")    //기본 매핑을 설정 하고
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/booklist") //똑같이 /booklist 경로에 요청 메서드 실행
    public String requestBookList(Model model) { //Model 객체 사용
        List<Book> allbooklist = bookService.getAllBookList();
        model.addAttribute("bookList", allbooklist);


        return "list/booklist";

    }
}
*/

/*@RequestMapping(value = "/booklist", method = RequestMethod.GET)과 @GetMapping("/booklist")는 기능적으로 동일하다*/


/* 3번 컨트롤러 ModelAndView , GetMapping */

@Controller
@RequestMapping("/list")
public class BookController {
    @Autowired
    private BookService bookService;

    //전체 출력
    @GetMapping("/booklist")
    public ModelAndView requestBookList(Integer cpg) { //ModelAndView 객체 사용
        ModelAndView mv = new ModelAndView();


        mv.addObject("bklist", bookService.getAllBookList(cpg));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1 );
        mv.addObject("cntpg", bookService.getCountBook()); //뷰 파일(jsp)로 보낼 데이터를 cntpg라는 이름으로 ModelAndView에 이름으로 넣어줌
        mv.setViewName("list/booklist");

        return mv;

    }
    //검색 기능
    @GetMapping("booklist/{category}")    //PathVariable 변수를 경로값으로 지정
    public ModelAndView requestBooksByCategory(Integer cpg,@PathVariable("category") String bookCategory, String fkey){
        ModelAndView mv = new ModelAndView();
        mv.addObject("bklist",bookService.getBookListByCategory(bookCategory,fkey,cpg));//sql문으로 페이지에 출력하는 데이터
        mv.addObject("cpg", cpg);//cpg로 페이지네이션 위치 표시
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1 ); //시작 페이지 계산하기
        mv.addObject("cntpg", bookService.getCountBookCategory(bookCategory,fkey) ); //총 페이지 개수
        //stpg나 cpg도 find라도 같게 해주자 - views에서 변수명을 같게 해줬으니까

        mv.setViewName("list/booklist");

        return mv;

    }

    //상세보기
    @GetMapping("/bookinfo")  //경로에 @PathVariable가 있다면 매개 변수에는 @RequestParam가 있다.
                                // booid라고 적지않고 id=로 적어도 bookid로 인식하도록 도와줌
    public String requestBookById(@RequestParam("id") String bookid,Model model){
        Book bookById = bookService.getBookInfo(bookid);
        model.addAttribute("bookinfo",bookById);


        return "list/bookinfo";
    }



    @GetMapping("/add") //@ModelAttribute 어노테이션은 jsp에있는 form에서 @ModelAttribute로 지정된 newbook을 의미한다.
    public String requestAddBookForm(@ModelAttribute("newbook")Book newbook){


        return "list/addBook";
    }
//GET 요청
// 겟 매퍼 따로 , 포스메퍼 따로다  그래서 버튼이 있다면 @ModelAttribute("newbook")Book newbook 를 두개 함수다 적어준다.
//"list/addBook" 뷰 페이지를 반환하고, 폼에 입력된 데이터를 처리하지 않습니다. 이는 폼을 초기화하고 사용자에게 폼을 보여주는 역할
// 여기에 적어준 @ModelAttribute("newbook")Book newbook는 초기화 해주는 역할 - 정확힌 어노테이션으로 처음 주소를 치면 지정된
// 텅빈 객체를 폼(newbook)에 전달   , ModelAttribute는 폼에도 , 컨트롤러에도 ModelAttribute로 존재함



   @PostMapping("/add")
   public String requestAddBookFormok(@ModelAttribute("newbook")Book newbook,Model model){ //뒤에 newbook으로 받아오고 model로 jsp에 전해줌

        String viewPage ="list/addbook";



        //addbook에서 input으로 적은 값에 type 파일로 가져온
        MultipartFile bookImage =newbook.getBookImage(); //업로드한 도서 이미지에 해당하는 매개변수를 MultipartFile 객체의 bookImage변수에 넣어줌
                                                        //model에 bookImage() 에 get으로 넣어준거임
        String saveName = bookImage.getOriginalFilename();  //MultipartFile 타입으로 전송 받은 이미지 파일 이름을 얻는다.
        //String savepath=bookImage.getFile(); //파일 형식

        File saveFile=new File("C:\\upload",saveName);  /* C:/upload 경로로 업로드 - File 클라스("경로"지정, 파일이름 변수 지정)*/
                                                                /*이렇게 하면 해당 경로에 파일이 업로드된 파일이 생성된다.*/
        if (bookImage != null && !bookImage.isEmpty()){
            try{

                bookImage.transferTo(saveFile);    //도서 이미지 파일을 경로로 업로드

            }catch (Exception e){
                throw new RuntimeException("도서 이미지 업로드가 실패했습니다.",e);
            }
        }

       String imagePath = saveName;  //여기 경로가 데이터베이스 경로 칼럼에 들어가는 값 파일이름
       newbook.setImagePath(imagePath);  //Book에 있는 경로 변수에 경로를 넣어준다.

       if (bookService.setNewBook(newbook)){
           viewPage="redirect:/list/booklist?cpg=1";
       }               //jsp에서 newbook으로 전달 받고 이걸 서비스 dao mapper 로 전달하도록한다.

       return viewPage;
    }
    //@ModelAttribute("newbook") 어노테이션을 @PostMapping("/add") 메서드에 적용하면,
    // 이 메서드는 전송된 폼 데이터를 해당 어노테이션으로 지정된 객체에 바인딩합니다. 
    // 즉, 폼에 입력된 데이터가 newbook 객체에 자동으로 매핑되어 컨트롤러 메서드에 전달됩니다. 
    // 이후 데이터 처리를 위해 newbook 객체를 사용



    @ModelAttribute   //model에 속성을 추가하기위해 사용
    public void addAttributes(Model model){
        model.addAttribute("addTitle","신규 도서 등록");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setAllowedFields("bookid","bkname","unitPrice","author","description","publisher",
                "category","unitsInStock","totalPages","releaseDate","cobd","bookImage");
    }





}




