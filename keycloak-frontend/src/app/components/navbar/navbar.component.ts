import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  userDetails: any;
  username: string;
  constructor(private keycloakService: KeycloakService, private dataService: DataService) { }

  async ngOnInit() {
    this.getuserinfo()
  }

  async getuserinfo() {
    if (await this.keycloakService.isLoggedIn()) {
      this.username = this.keycloakService.getUsername()
    }
  }

  async doLogout() {
    await this.keycloakService.logout();
  }


}
