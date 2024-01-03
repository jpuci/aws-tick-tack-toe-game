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
      localStorage.setItem("gameId", JSON.parse(message.body).gameId)
      if (JSON.parse(message.body).status == "matched" && !localStorage.getItem("playAs")){
        localStorage.setItem("playAs", "X");
        this.router.navigate(['/game']);
      } else {

        localStorage.setItem("playAs", "O")
      }


    });

    const message = JSON.stringify({username: localStorage.getItem('username')});
    this.rxStompService.publish({destination: '/app/hello', body: String(message)})
  }

}
