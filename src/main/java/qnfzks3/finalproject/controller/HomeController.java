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

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Locale locale, Model model){ //home은 요청 처리 메서드
        logger.info("Welcome home! the client locale is {}." , locale);

        Date date= new Date();
        DateFormat dateFormat= DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime",formattedDate);

        return "index";
        
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
