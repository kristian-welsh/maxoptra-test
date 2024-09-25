package com.maxoptra.kwelsh;

import java.lang.Integer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }

    @RequestMapping("calc")
    Integer calc(@RequestParam int left, @RequestParam int right) {
        return left + right;
    }
}
