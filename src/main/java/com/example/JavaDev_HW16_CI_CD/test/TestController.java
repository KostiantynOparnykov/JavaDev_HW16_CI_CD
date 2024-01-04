package com.example.JavaDev_HW16_CI_CD.test;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor

public class TestController {

    private TestService service;
    @GetMapping("/test")

    public ModelAndView getTest(){
        ModelAndView result = new ModelAndView("test");
        result.addObject("message", service.message());
        return result;
    }
}
