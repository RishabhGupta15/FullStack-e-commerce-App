import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../common/user.model';
import { UserResponseModel } from '../common/user-response.model';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = "http://localhost:9090/v2/api/user";

  constructor(private httpClient: HttpClient) { }

  getLoginUser(loginDetails: UserResponseModel){
    return this.httpClient.post<User>(`${this.baseUrl}/login`, loginDetails);
  }
}
