import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  constructor(private userservice: UserService,
  private snack:MatSnackBar) { }

  public user = {
    username: '',
    password: '',
    email: '',
    phone: '',
  };

  ngOnInit(): void {}
  formSubmit() {
    console.log('form submitted');
    console.log(this.user);

    this.userservice.addUser(this.user).subscribe(
      (data) => {
        console.log(data);
        alert('success');
      },
      (error) => {
        console.log(error);
        //alert('error');
        //this.snack.open('error', 'close', {duration: 2000});
        Swal.fire('error', 'error', 'error');
      }
    );
  }

  //addUser
}
