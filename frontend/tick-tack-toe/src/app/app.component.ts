import { Component } from '@angular/core';
import {RxStompConfig} from "@stomp/rx-stomp";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'tick-tack-toe';
  stock: any = {};
  protected readonly RxStompConfig = RxStompConfig;
  constructor() {
  }
}
