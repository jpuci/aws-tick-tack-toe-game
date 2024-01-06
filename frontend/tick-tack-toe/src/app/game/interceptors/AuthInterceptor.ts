import { Injectable } from '@angular/core';
import {HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse} from '@angular/common/http';
import {catchError, Observable, throwError} from "rxjs";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler):  Observable<HttpEvent<any>> {
    const authToken = this.getAuthToken(); // Implement this method to retrieve your token

    if (req.url.endsWith('/login')) {
      // Allow login requests to go through without modification
      return next.handle(req);
    }
    const authReq = req.clone({
      headers: req.headers.set('Authorization', 'Bearer ' + authToken)
    });


    return next.handle(authReq).pipe(
      catchError((error: HttpErrorResponse) => {

        return throwError(error);
      })
    );
  }

  private getAuthToken(): string {
    // Retrieve your token from where you have stored it (e.g., localStorage)
    return localStorage.getItem('jwtToken') || "";
  }
}
