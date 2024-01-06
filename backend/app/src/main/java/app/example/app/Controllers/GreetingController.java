package app.example.app.Controllers;


import app.example.app.Entities.Ask;
import app.example.app.Entities.Game;
import app.example.app.Entities.Greeting;
import app.example.app.Entities.HelloMessage;
import app.example.app.Repositories.GameRepository;
//import app.example.app.config.MyWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public GreetingController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Autowired
    GameRepository gameRepository;
//    @Autowired
//    private MyWebSocketHandler webSocketHandler;
    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
    public void ask(HelloMessage message) throws Exception {
        Game game = gameRepository.findGameByGameStatus("Not Started");
        if (game != null){
            game.setUser2(HtmlUtils.htmlEscape(message.getUsername()));
            game.setGameStatus("Started");
            gameRepository.save(game);
//            return new Ask("matched", game.getId());
//            webSocketHandler.sendMessageToAll("matched");
            Ask ask = new Ask("matched", game.getId());
            ask.setUser2(HtmlUtils.htmlEscape(message.getUsername()));
            this.simpMessagingTemplate.convertAndSend("/topic/greetings", ask);

        } else {
            Game newGame = new Game();
            newGame.setUser1(HtmlUtils.htmlEscape(message.getUsername()));
            gameRepository.save(newGame);
//            return new Ask("waiting for match");
            Ask ask = new Ask("waiting for match", newGame.getId());
            ask.setUser1(HtmlUtils.htmlEscape(message.getUsername()));
            this.simpMessagingTemplate.convertAndSend("/topic/greetings", ask);
        };


    }
}