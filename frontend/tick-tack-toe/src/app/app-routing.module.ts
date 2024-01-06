import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {GameplayComponent} from "./game/components/gameplay/gameplay.component";
import {AppComponent} from "./app.component";
import {LoginComponent} from "./game/components/login/login.component";
import {WaitingComponent} from "./game/components/waiting/waiting.component";
import {MenuComponent} from "./game/components/menu/menu.component";
import {LeaderboardComponent} from "./game/components/leaderboard/leaderboard.component";

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: '/login',
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    pathMatch: 'full',
    component: AppComponent
  },
  {
    path: 'main',
    component: AppComponent
  },
  {
    path: 'game',
    component: GameplayComponent
  },
  {
    path: 'waiting',
    component: WaitingComponent
  },
  {
    path: 'menu',
    component: MenuComponent
  },
  {
    path: 'leaderboard',
    component: LeaderboardComponent
  }

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
