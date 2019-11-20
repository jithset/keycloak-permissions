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

  ngOnInit() {
    this.getuserinfo()
  }

  async getuserinfo() {
    // if (await this.keycloakService.isLoggedIn()) {
    //   this.userDetails = await this.keycloakService.loadUserProfile();
    //   this.isAdmin = this.authService.getRoles('admin');
    //   this.isEmployee = this.authService.getRoles('employee');
    //   console.log(this.userDetails);      
    // }
    console.log("getuserinfo");

    if (await this.keycloakService.isLoggedIn()) {
      this.username = this.keycloakService.getUsername()
      this.dataService.getUserByUsername(this.username).subscribe(res => {
        this.userDetails = res[0];
        console.log(this.userDetails);
      }
      );
    }
  }

  async doLogout() {
    await this.keycloakService.logout();
  }


}
