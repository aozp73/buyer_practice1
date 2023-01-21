package shop.mtcoding.buyer3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/notfound")
    public String error() {
        return "error/notfound";
    }
}
