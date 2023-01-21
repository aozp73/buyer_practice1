package shop.mtcoding.buyer3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {

    @GetMapping("test")
    public String tes(){
        return "test";
    }
}
