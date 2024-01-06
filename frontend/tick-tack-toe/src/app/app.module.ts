import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { GameplayComponent } from './game/components/gameplay/gameplay.component';
import {AppRoutingModule} from "./app-routing.module";
import {FormsModule} from "@angular/forms";
import {RxStompServiceFactory} from "./game/services/rx-stomp-service-factory";
import {RxStompService} from "./game/services/rx-stomp.service";
import { MessagesComponent } from './game/components/messages/messages.component';
import { LoginComponent } from './game/components/login/login.component';
import {MatCheckboxModule} from '@angular/material/checkbox'
import {RouterLink, RouterLinkActive, RouterModule, RouterOutlet} from '@angular/router';
import {RouterTestingModule} from "@angular/router/testing";
import {UserService} from "./game/services/user.service";
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from "@angular/common/http";
import { WaitingComponent } from './game/components/waiting/waiting.component';
import { MenuComponent } from './game/components/menu/menu.component';
import { LeaderboardComponent } from './game/components/leaderboard/leaderboard.component';
import {AuthInterceptor} from "./game/interceptors/AuthInterceptor";
@NgModule({
  declarations: [
    AppComponent,
    GameplayComponent,
    MessagesComponent,
    LoginComponent,
    WaitingComponent,
    MenuComponent,
    LeaderboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MatCheckboxModule,
    RouterOutlet,
    RouterModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: RxStompService,
      useFactory: RxStompServiceFactory,
    },
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    UserService,
    HttpClient
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
