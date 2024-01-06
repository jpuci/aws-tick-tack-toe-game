import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {LeaderboardService} from "../../services/leaderboard.service";
import {catchError, tap} from "rxjs";
import {LeaderBoard} from "../../model/LeaderBoard";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements  OnInit{


  constructor(private readonly router: Router) {}

  ngOnInit() {

  }
  navigateTo(location: string){
    this.router.navigate([location])
  }

  logout(){
    localStorage.removeItem("username")
    localStorage.removeItem("jwtToken")
    this.router.navigate(['/login'])
  }

}
