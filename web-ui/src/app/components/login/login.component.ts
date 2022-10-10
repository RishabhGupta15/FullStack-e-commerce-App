import { Component, OnInit } from '@angular/core';
import { LoginSessionService } from 'src/app/services/util/login-session.service';
import { UserService } from 'src/app/services/user.service';
import { UserResponseModel } from 'src/app/common/user-response.model';
import { Router } from '@angular/router';
import { UserLoginDetails } from 'src/app/common/user-session-details';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    public userService: UserService,
    public router: Router
  ) { }

  ngOnInit(): void {
  }

  onLogin(username: HTMLInputElement, pwd: HTMLInputElement){
    let userDetails: UserResponseModel = new UserResponseModel(username.value, pwd.value);
    this.userService.getLoginUser(userDetails).subscribe(
      data => {
        console.log("------");
        console.log(data);
      }
    );

    this.loadProductList();
    UserLoginDetails.USERNAME = username.value;
    console.log(UserLoginDetails.USERNAME);
  }

  loadProductList(){
    this.router.navigate(["/products"]);
  }

}
