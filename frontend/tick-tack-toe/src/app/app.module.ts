import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { GameplayComponent } from './game/components/gameplay/gameplay.component';
import {AppRoutingModule} from "./app-routing.module";
import {FormsModule} from "@angular/forms";
import {RxStompServiceFactory} from "./game/services/rx-stomp-service-factory";
import {RxStompService} from "./game/services/rx-stomp.service";
import { MessagesComponent } from './game/components/messages/messages.component';

@NgModule({
  declarations: [
    AppComponent,
    GameplayComponent,
    MessagesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    {
      provide: RxStompService,
      useFactory: RxStompServiceFactory,
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
