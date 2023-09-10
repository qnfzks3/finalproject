package qnfzks3.finalproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)   //이건 get 방식이다. - 서버에서 / 를 요청 하면 아래를 실행하라
    public String home(Locale locale, Model model){ //home은 요청 처리 메서드
        logger.info("Welcome home! the client locale is {}." , locale);

        Date date= new Date();
        DateFormat dateFormat= DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime",formattedDate);

        //WEB-INF/views/ + index + .jsp  이렇게 경로를 찾음  이게 어디서 설정 해놓았는가? - servlet-context.xml에서 설정해놓음
        // 만약 서블릿에서 설정하지 않았다면 위에 경로 전부 적어주어야한다.
        
        return "index";  //이렇게 요청한 jsp(html)을 post 해서 보낸다
        
    }

    @RequestMapping(value = "/bookindex",method = RequestMethod.GET)
    public String bookindex(Locale locale, Model model){ //home은 요청 처리 메서드
        logger.info("Welcome home! the client locale is {}." , locale);
        Date date= new Date();
        DateFormat dateFormat= DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime",formattedDate);



        return "bookindex";

    }




}
