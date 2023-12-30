package app.example.app.Controllers;


import app.example.app.Entities.Game;
import app.example.app.Entities.Greeting;
import app.example.app.Entities.HelloMessage;
import app.example.app.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @Autowired
    GameRepository gameRepository;
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting() throws Exception {
        Game game = new Game();
        gameRepository.save(game);
        return new Greeting(game.getId().toString());
    }
}