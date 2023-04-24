package pl.jakubokrzesik;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
    @GetMapping("/")
    String hello() {
        return "yo";
    }
}
