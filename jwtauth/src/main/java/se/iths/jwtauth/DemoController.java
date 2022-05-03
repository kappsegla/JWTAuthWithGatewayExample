package se.iths.jwtauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @GetMapping("/persons")
    public List<String> all() {
        return List.of("Martin","Kalle");
    }
}
