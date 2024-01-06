import {Component, OnInit} from '@angular/core';
import {LeaderBoard} from "../../model/LeaderBoard";
import {Router} from "@angular/router";
import {LeaderboardService} from "../../services/leaderboard.service";

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit{

  leaderBoard: LeaderBoard[] = [];

  constructor(private readonly router: Router, private leaderboardService: LeaderboardService) {
  }

  ngOnInit() {
    this.leaderboardService.getLeaderBoard().subscribe(data =>
      this.leaderBoard = data
    )
    console.log(this.leaderBoard);
  }

}
