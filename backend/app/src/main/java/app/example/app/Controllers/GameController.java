package app.example.app.Controllers;

import app.example.app.Entities.Game;
import app.example.app.Entities.Greeting;
import app.example.app.Entities.HelloMessage;
import app.example.app.Entities.Move;
import app.example.app.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.HtmlUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
@CrossOrigin(origins = "${cross.origin}")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @MessageMapping("/move")
    @SendTo("/topic/game")
    public Game game(Move move) throws Exception {
        System.out.println(move);
        Integer moveType = move.getMoveType();
        Integer id = move.getId();
        System.out.println(moveType);
        System.out.println(id);
        Game game = gameRepository.findGameById(move.getGameId().longValue());
        ArrayList board = game.getArrayBoard();
        board.set(id, moveType);
        System.out.println(board);

        return new Game();
    }


    @PostMapping(value = "/test", consumes = {"application/json"})
    public ResponseEntity<String> createQuestion(@AuthenticationPrincipal Jwt jwt) {
        return ResponseEntity.status(HttpStatus.CREATED).body("OK!");
    }
}
