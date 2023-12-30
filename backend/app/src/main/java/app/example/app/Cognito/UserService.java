package app.example.app.Cognito;

import app.example.app.Entities.User;
import app.example.app.Entities.UserRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User registerUser(UserRegistrationRequest userRegistrationRequest);
    User loginUser(String username, String password);
}
