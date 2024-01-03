package app.example.app.Controllers;


import app.example.app.Entities.Ask;
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
    public Ask ask(HelloMessage message) throws Exception {
        Game game = gameRepository.findGameByGameStatus("Not Started");
        if (game != null){
            game.setUser2(HtmlUtils.htmlEscape(message.getUsername()));
            game.setGameStatus("Started");
            gameRepository.save(game);
            return new Ask("matched", game.getId());

        } else {
            Game newGame = new Game();
            newGame.setUser1(HtmlUtils.htmlEscape(message.getUsername()));
            gameRepository.save(newGame);
            return new Ask("waiting for match");
        }

    }
}