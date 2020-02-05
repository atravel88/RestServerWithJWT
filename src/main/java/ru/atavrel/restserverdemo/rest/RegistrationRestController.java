package ru.atavrel.restserverdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.atavrel.restserverdemo.model.User;
import ru.atavrel.restserverdemo.service.UserService;

@RestController
@CrossOrigin(value = "http://localhost:8080", allowCredentials = "false")
@RequestMapping("/api/registration/users")
public class RegistrationRestController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //GET: http://localhost:8075/api/registration/users/email/{email}
    @GetMapping("/email/{email}")
    public ResponseEntity<Boolean> getUserByEmail(@PathVariable("email") String email) {
        User user = userService.getUserByEmail(email);
        if (user == null) {
            return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //POST: http://localhost:8075/api/registration/users/
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        userService.add(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}