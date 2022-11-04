import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  public loginStatusSubject = new Subject<boolean>();

  constructor(private http: HttpClient) {}

  //current user: which is loggedin
  public getCurrentuser() {
    return this.http.get(`${baseUrl}/current-user`);
  }

  //generate token
  public generateToken(loginData: any) {
    return this.http.post(`${baseUrl}/generate-token`, loginData);
  }

  //login user: set token in local storage
  public loginUser(token: any) {
    localStorage.setItem('token', token);
    
    return true;
  }

  //check if user is logged in
  public isLoggedIn() {
    let tokenStr = localStorage.getItem('token');
    if (tokenStr == undefined || tokenStr == null || tokenStr == '') {
      return false;
    } else {
      return true;
    }
  }

  //logout user: remove token from local storage
  public logout() {
    localStorage.removeItem('token');
    return true;
  }

  //get token from local storage
  public getToken() {
    return localStorage.getItem('token');
  }

  //set user data in local storage
  public setUser(user: any) {
    localStorage.setItem('user', JSON.stringify(user));
  }

  //get user data from local storage
  public getUser() {
    let userStr = localStorage.getItem('user');
    if (userStr != null) {
      return JSON.parse(userStr);
    } else {
      this.logout();
      return null;
    }
  }

  //get user role
  public getUserRole() {
    let user = this.getUser();
    if (user != null) {
      return user.authorities[0].authority;
    } else {
      return "Normal";
    }
  }
  
  //get user username
  public getUsername() {
    let user = this.getUser();
  if (user != null) {
    return user.username;
  } else {
    return null;
  }



  }



}
