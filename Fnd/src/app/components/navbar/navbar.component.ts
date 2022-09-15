import { Component, Input, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  isLoggedIn = false;

  //user = null;
  @Input() user;
  @Input() auth;

  constructor(public login: LoginService) {}

  ngOnInit(): void {
    this.isLoggedIn = this.login.isLoggedIn();
    this.user = this.login.getUser();
    this.login.loginStatusSubject.asObservable().subscribe((data: any) => {
      this.isLoggedIn = this.login.isLoggedIn();
      this.user = this.login.getUser();
    });
    this.auth = this.login.getUser().authorities[0].authority;

    //console.log(this.login.getUser().authorities[0].authority);
    //console.log(this.auth);
  }
  public logout() {
    this.login.logout();
    window.location.reload();
    // this.login.loginStatusSubject.next(false);
  }
}
