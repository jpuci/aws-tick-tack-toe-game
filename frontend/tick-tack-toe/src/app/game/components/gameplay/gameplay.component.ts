import {Component, OnDestroy, OnInit} from '@angular/core';
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

export class GameplayComponent implements OnInit, OnDestroy{
  game = new Array<string>(9).fill('');
  board: string = ".........";
  receivedMessages: string[] = [];
  receivedGreetings: string[] = [];
  playAs: string = localStorage.getItem("playAs") || "";
  gameId: string = localStorage.getItem("gameId") || "";
  canMove: boolean = false;
  won: boolean = false;
  lost: boolean = false;
  draw: boolean = false;
  // components: string[];
  constructor(private rxStompService: RxStompService, private userService: UserService, private readonly router: Router) {}

  ngOnInit(): void {
    console.log(this.userService.isAuthenticated());
    if (this.userService.isAuthenticated()){
      this.rxStompService.watch(`/topic/game/${this.gameId}`).subscribe((message: Message) => {
        console.log('received messages', this.receivedMessages);
        this.receivedMessages.push(JSON.parse(message.body).board);
        this.board = JSON.parse(message.body).board;
        this.game = this.boardToGame(this.board);
        const moveType = JSON.parse(message.body).moveType;
        if (moveType == this.playAs && !moveType.includes("W") && !moveType.includes("W")){
          this.canMove=true;
        }
        console.log(moveType)
        if (moveType.includes("W")){
          if (moveType === this.playAs + "W" ){
            this.won = true;
          } else {
            this.lost = true;
          }
          this.canMove = false;
        } else if (moveType === "D"){
          this.draw = true
          this.canMove = false;
        }
      });
      if (this.playAs === "O"){
        this.canMove = true;
      }
    }
    else {
      this.router.navigate(["/"])
    }

  }
  move(id: string): void{
    console.log(this.canMove)
    if (this.canMove){
      let num = Number(id.replace('b', '')) - 1;
      this.game[num] = this.playAs
      console.log(this.game)
      this.board = this.replaceChar(this.board, this.playAs, num);
      this.onSendMessage();
    }
  }
  onSendMessage() {
    const message = JSON.stringify({gameId : this.gameId, moveType : this.playAs, board : this.board});
    this.rxStompService.publish({ destination: '/app/move', body: String(message) });
    this.canMove = false;
  }

  replaceChar(board: string, move: string, index: number) : string{
    return board.substring(0, index) + move + board.substring(index + 1);
  }

  boardToGame(board: String) : string[] {
    var tmp = board.split("");
    return tmp.map(x => x.replace(".", ""));
  }

  onPlayAgain(){
    localStorage.removeItem("gameId");
    localStorage.removeItem("playAs")
    this.router.navigate(["/waiting"])
  }

  ngOnDestroy() {
    localStorage.removeItem("playAs")
    localStorage.removeItem("gameId")
  }
}
