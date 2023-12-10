import {Component, OnInit} from '@angular/core';
// import {WebsocketService} from "../../services/websocket.service";

@Component({
  selector: 'app-gameplay',
  templateUrl: './gameplay.component.html',
  styleUrls: ['./gameplay.component.css']
})

export class GameplayComponent implements OnInit{
  game = new Array<number>(9).fill(0);
  receivedMessages: string[] = [];
  constructor() {}

  ngOnInit(): void {}
  move(id: string): void{
    document.getElementById(id);
    console.log(id);
  }
}
