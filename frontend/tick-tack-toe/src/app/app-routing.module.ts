import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {GameplayComponent} from "./game/components/gameplay/gameplay.component";
import {RegisterComponent} from "./game/components/register/register.component";
import {AppComponent} from "./app.component";
import {LoginComponent} from "./game/components/login/login.component";

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
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'register2',
    component: RegisterComponent
  }

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
