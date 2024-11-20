package br.com.jeffmonteiro.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired // Manage all the lifecycle
    private IUserRepository userRepository;
    @PostMapping("/")
    public UserModel create(@RequestBody UserModel userModel) {
        var userCreated = this.userRepository.save(userModel);
        return userCreated;
    }
}
