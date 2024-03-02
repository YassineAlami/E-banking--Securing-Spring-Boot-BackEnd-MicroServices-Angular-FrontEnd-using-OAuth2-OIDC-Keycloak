import {Component, OnInit} from '@angular/core';
import {SecurityService} from "./services/security.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'customer-angular';


  constructor(public securityService:SecurityService) {
  }

  ngOnInit(): void {
  }

  login() {

  }

  logout() {

  }
}
