package app.example.app.Cognito;

import app.example.app.Entities.User;
import app.example.app.Entities.UserRegistrationRequest;
import app.example.app.Repositories.UserRepository;
import app.example.app.Services.CognitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CognitoService cognitoService;

    @Override
    public User registerUser(UserRegistrationRequest userRegistrationRequest) {
        String username = userRegistrationRequest.getUsername();
        String password = userRegistrationRequest.getPassword();
        String email = userRegistrationRequest.getEmail();
        // Register the user with Amazon Cognito
        return cognitoService.registerUser(username, email, password);
    }

    @Override
    public User loginUser(String username, String password) {
        return cognitoService.loginUser(username, password);
    }
}