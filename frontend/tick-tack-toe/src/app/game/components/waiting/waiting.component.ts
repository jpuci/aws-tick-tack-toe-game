import {Component, OnInit} from '@angular/core';
import {RxStompService} from "../../services/rx-stomp.service";
import {Message} from "@stomp/stompjs/esm6";
import {Router} from "@angular/router";

@Component({
  selector: 'app-waiting',
  templateUrl: './waiting.component.html',
  styleUrls: ['./waiting.component.css']
})

export class WaitingComponent implements OnInit {
  receivedMessages: string[] = [];

  constructor(private rxStompService: RxStompService, private readonly router: Router) {
  }

  ngOnInit(): void {
    this.rxStompService.watch('/topic/greetings').subscribe((message: Message) => {
      this.receivedMessages.push(JSON.parse(message.body).status);
      localStorage.setItem("gameId", JSON.parse(message.body).gameId);
      console.log(message);

      if (JSON.parse(message.body).user2 === localStorage.getItem("username")){
        localStorage.setItem("playAs", "X");
      } else if (JSON.parse(message.body).user1 === localStorage.getItem("username")){
        localStorage.setItem("playAs", "O");
      }

      if (JSON.parse(message.body).status == "matched"){
        this.router.navigate(['/game']);
      }


    });

    const message = JSON.stringify({username: localStorage.getItem('username')});
    this.rxStompService.publish({destination: '/app/hello', body: String(message)})
  }

}
