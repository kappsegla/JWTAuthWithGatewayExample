package com.example.swagger;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    private List<User> getAllUser() {
        return List.of();
    }

    @GetMapping("/users/{userid}")
    private User getUser(@PathVariable("userid") int userid) {
        return new User();
    }

    @DeleteMapping("/users/{userid}")
    private void deleteBook(@PathVariable("userid") int userid) {

    }

    @PostMapping("/users")
    private int saveBook(@RequestBody User user) {
        return 0;
    }

    @PutMapping("/users")
    private User update(@RequestBody User user) {
        return user;
    }
}
