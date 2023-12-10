import { Component, OnInit } from '@angular/core';
import { Message } from '@stomp/stompjs';
import {RxStompService} from "../../services/rx-stomp.service";

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css'],
})
export class MessagesComponent implements OnInit {
  receivedMessages: string[] = [];

  constructor(private rxStompService: RxStompService) {}

  ngOnInit(): void {
    this.rxStompService.watch('/topic/greetings').subscribe((message: Message) => {
      console.log(this.receivedMessages);
      this.receivedMessages.push(JSON.parse(message.body).content);
    });
  }

  onSendMessage() {
    const message = JSON.stringify({name : 'Asia'});
    this.rxStompService.publish({ destination: '/app/hello', body: String(message) });
  }
}
