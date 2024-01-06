import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";

import {JwtHelperService} from "@auth0/angular-jwt";
import {environment} from "../../../environments/environment";
import {LeaderBoard} from "../model/LeaderBoard"

@Injectable({
  providedIn: 'root'
})
export class LeaderboardService {
  helper = new JwtHelperService();
  private baseURL = 'http://' + `${environment.location}` + ':8080'
  constructor(private http: HttpClient) { }
  getLeaderBoard(): Observable<LeaderBoard[]> {
    return this.http.get<any>(`${(this.baseURL)}/get-leaderboard`);
  }
}
