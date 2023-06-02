package qnfzks3.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class Exam01Controller {

    @RequestMapping(value = "/exam01", method = RequestMethod.GET)
    public void requestMethod(){
        System.out.println("@Controller 예제 입니다.");
    }


}
