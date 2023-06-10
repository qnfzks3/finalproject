package qnfzks3.finalproject.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Exam03Controller {
    private static final Logger logger = LoggerFactory.getLogger(Exam03Controller.class);
    @GetMapping("/cars/{color}")
    public String requestMethod(@PathVariable String color){

        logger.info("Color = {}." , color);

        return "cars";
    }




}
