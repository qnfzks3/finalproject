package qnfzks3.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Exam02Controller {
    
    @RequestMapping("/exam02")
    public void requestMethod(){
        System.out.println("@RequestMapping 예제입니다");
        System.out.println("웹 요청 URL은 /exam02 입니다");

    }
}
