import {Component, OnInit} from '@angular/core';
import {MatCheckboxModule} from '@angular/material/checkbox'
import {Router, RouterModule} from '@angular/router';
import {RxStompService} from "../../services/rx-stomp.service";
import {Message} from "@stomp/stompjs";
import {UserService} from "../../services/user.service";
import {catchError, tap} from "rxjs";
import { JwtHelperService } from '@auth0/angular-jwt';
import { of } from 'rxjs';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  username: string = '';
  password: string = '';
  receivedMessages: string[] = [];
  errorMessage: string = '';
  helper = new JwtHelperService();
  isIncorrect= false;
  constructor(private readonly router: Router, private rxStompService: RxStompService, private userService: UserService) {

  }

  onSubmit(){
      this.userService.login({
        username: this.username,
        password: this.password
      }).pipe(
        catchError(error => {
          this.isIncorrect = true;
          console.log("login failed")
          this.errorMessage = error.error
          return of(null);

        }),
        tap((response: any) => {
          if (response){
            localStorage.setItem("username", this.username)
            localStorage.setItem("jwtToken", response.accessToken);
            this.router.navigate(['/menu']);
          }
        })).subscribe();
  }


  ngOnInit(): void {
    //@ts-ignore
    console.log(window['env'])
    // this.rxStompService.watch('/topic/greetings').subscribe((message: Message) => {
    //   console.log(this.receivedMessages);
    //   this.receivedMessages.push(JSON.parse(message.body).content);
    //   localStorage.setItem('gameId', JSON.stringify(this.receivedMessages[this.receivedMessages.length-1]));
    // });
    console.log("done init")
  }

  onSendMessage() {
    const message = JSON.stringify({game : 'new'});
    this.rxStompService.publish({ destination: '/app/hello', body: String(message) });
  }

}
