import { Component, OnInit, Input } from '@angular/core';
import { LoginSessionService } from 'src/app/services/util/login-session.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(
  ) { }

  username: string = "default user";

  ngOnInit(): void {
  }

}
