import { Component, OnInit, Input } from '@angular/core';
import { LoginSessionService } from 'src/app/services/util/login-session.service';
import { UserLoginDetails } from 'src/app/common/user-session-details';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(
  ) { }

  username: string = UserLoginDetails.USERNAME;

  ngOnInit(): void {
  }

}
