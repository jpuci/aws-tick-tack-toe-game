package app.example.app.Controllers;

import app.example.app.Cognito.UserServiceImpl;
import app.example.app.Entities.User;
import app.example.app.Entities.UserLoginRequest;
import app.example.app.Entities.UserRegistrationRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@Valid @RequestBody UserLoginRequest userLoginRequest) {
        // Perform user login
        User loggedInUser = userService.loginUser(userLoginRequest.getUsername(), userLoginRequest.getPassword());

        if (loggedInUser != null) {
            // Successful login
            return ResponseEntity.ok(loggedInUser);
        } else {
            // Invalid login, return an appropriate response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
