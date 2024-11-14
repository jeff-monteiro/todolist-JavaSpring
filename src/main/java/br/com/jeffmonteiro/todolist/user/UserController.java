package br.com.jeffmonteiro.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Modificadores
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping("/")
    public void create(@RequestBody UserModel userModel) {
        System.out.println(userModel.getName());
        System.out.println(userModel.getPassword());
        System.out.println(userModel.getUsername());
    }
}
