import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {environment} from "../../../environments/environment";
import * as JWT from 'jwt-decode';
import {JwtHelperService} from "@auth0/angular-jwt";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  helper = new JwtHelperService();
  constructor(private http: HttpClient) { }
  login(credentials: any): Observable<any> {
    console.log(`${environment.baseURL}/login`)
    return this.http.post<any>(`${environment.baseURL}/login`, credentials);
  }

  getToken(): string {
    return localStorage.getItem('jwtToken') || ""
  }

  isAuthenticated(): boolean {
    const token = this.getToken();
    if (token) {
      const decodedToken: any = this.helper.decodeToken(token); // Decode the token
      const expirationDate = new Date(decodedToken.exp * 1000); // Convert the expiration date to milliseconds
      const currentDate = new Date();

      return expirationDate > currentDate; // Check if the token is not expired
    }

    return false; // Return false if the token is not found
  }
}
