package app.example.app.Controllers;

import app.example.app.Entities.Game;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class GameController {
//    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
//    public Game send(Long id, String status, String board) throws Exception {
//        return new Game(id, status, board);
//    }
}
