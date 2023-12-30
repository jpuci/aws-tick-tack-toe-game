package app.example.app.Services;

import app.example.app.Cognito.CalculateSecretHash;
import app.example.app.Entities.User;
import app.example.app.Repositories.UserRepository;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

import static app.example.app.Cognito.CalculateSecretHash.calculateSecretHash;

@Service
public class CognitoService {
    @Value("${spring.security.oauth2.client.registration.cognito.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.cognito.client-secret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.client.registration.cognito.scope}")
    private String scope;

    @Value("${spring.security.oauth2.client.provider.cognito.issuer-uri}")
    private String issuerUri;

    @Value("${spring.security.oauth2.client.registration.cognito.client-name}")
    private String clientName;

    @Autowired
    private AWSCognitoIdentityProvider cognitoIdentityProvider;

    @Autowired
    private UserRepository userRepository;


    public User registerUser(String username, String email, String password) {
        // Set up the AWS Cognito registration request
        SignUpRequest signUpRequest = new SignUpRequest()
                .withClientId(clientId)
                .withUsername(username)
                .withPassword(password)
                .withSecretHash(calculateSecretHash(clientId, clientSecret, username))
                .withUserAttributes(
                        new AttributeType().withName("email").withValue(email)
                );

        // Register the user with Amazon Cognito
        try {
            SignUpResult signUpResponse = cognitoIdentityProvider.signUp(signUpRequest);

            User registeredUser = new User();
            registeredUser.setUsername(username);
            registeredUser.setEmail(email);
            registeredUser.setPassword(password);

            return userRepository.save(registeredUser);

        } catch (Exception e) {
            throw new RuntimeException("User registration failed: " + e.getMessage(), e);
        }
    }

    public User loginUser(String username, String password) {
        // Set up the authentication request
        InitiateAuthRequest authRequest = new InitiateAuthRequest()
                .withAuthFlow("USER_PASSWORD_AUTH")
                .withClientId(clientId)
                .withAuthParameters(
                        Map.of(
                                "USERNAME", username,   // Use email as the username
                                "PASSWORD", password,
                                "SECRET_HASH", calculateSecretHash(clientId, clientSecret, username)
                        )
                );

        try {
            InitiateAuthResult authResult = cognitoIdentityProvider.initiateAuth(authRequest);
            System.out.println(authResult);
            AuthenticationResultType authResponse = authResult.getAuthenticationResult();

            // At this point, the user is successfully authenticated, and you can access JWT tokens:
            String accessToken = authResponse.getAccessToken();
            String idToken = authResponse.getIdToken();
            String refreshToken = authResponse.getRefreshToken();

            // You can decode and verify the JWT tokens for user information

            User loggedInUser = new User();
            loggedInUser.setUsername(username);
            loggedInUser.setAccessToken(accessToken); // Store the token for future requests

            return loggedInUser;

        } catch (Exception e) {
            throw new RuntimeException("User login failed: " + e.getMessage(), e);
        }
    }
}
