import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {GameplayComponent} from "./game/components/gameplay/gameplay.component";

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: '/main'
  },
  {
    path: 'game',
    component: GameplayComponent
  }

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
