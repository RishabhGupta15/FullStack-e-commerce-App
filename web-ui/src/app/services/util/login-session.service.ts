import { Injectable } from '@angular/core';
import { UserResponseModel } from 'src/app/common/user-response.model';

@Injectable({
  providedIn: 'root'
})
export class LoginSessionService {

  constructor(
    public loggedinUser: UserResponseModel
  ) { }

  getLoggedInUser(){
    return this.loggedinUser.username;
  }
}
