package com.example.authentification.Controller;

import com.example.authentification.Entity.UserEntity;
import com.example.authentification.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/list")
    List<UserEntity> getAll(){
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    public UserEntity deleteUser(@PathVariable int id) {
            return userService.delete(id);

    }

}
