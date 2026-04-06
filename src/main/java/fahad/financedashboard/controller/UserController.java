package fahad.financedashboard.controller;

import fahad.financedashboard.entity.User;
import fahad.financedashboard.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public User createUser(
            @RequestBody User user
    ) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody User user
    ) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(
            @PathVariable Long id
    ) {
        userService.deleteUser(id);
    }
}
