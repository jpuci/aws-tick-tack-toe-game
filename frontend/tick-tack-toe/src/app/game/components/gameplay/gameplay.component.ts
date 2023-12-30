import {Component, OnInit} from '@angular/core';
import {Message} from "@stomp/stompjs";
import {RxStompService} from "../../services/rx-stomp.service";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
// import {WebsocketService} from "../../services/websocket.service";

@Component({
  selector: 'app-gameplay',
  templateUrl: './gameplay.component.html',
  styleUrls: ['./gameplay.component.css']
})

export class GameplayComponent implements OnInit{
  game = new Array<string>(9).fill('');
  receivedMessages: string[] = [];
  receivedGreetings: string[] = [];
  // components: string[];
  constructor(private rxStompService: RxStompService, private userService: UserService, private readonly router: Router) {}

  ngOnInit(): void {
    if (this.userService.isAuthenticated()){
      this.rxStompService.watch('/topic/game').subscribe((message: Message) => {
        console.log('received messages', this.receivedMessages);
        this.receivedMessages.push(JSON.parse(message.body).board);
      });
      //in case in login this doesn't happen
      this.rxStompService.watch('/topic/greetings').subscribe((message: Message) => {
        console.log(this.receivedGreetings);
        this.receivedGreetings.push(JSON.parse(message.body).content);
        localStorage.setItem('gameId', JSON.stringify(this.receivedGreetings[this.receivedGreetings.length-1]));
      });
    }
    else {
      this.router.navigate(["/"])
    }

  }
  move(id: string): void{
    let num = Number(id.replace('b', '')) - 1;
    this.game[num] = 'X';
    console.log(this.game)
    this.onSendMessage(num);
  }
  onSendMessage(id: number) {
    const message = JSON.stringify({id : id, moveType : 0, gameId : localStorage.getItem('gameId')});
    this.rxStompService.publish({ destination: '/app/move', body: String(message) });
  }
}
