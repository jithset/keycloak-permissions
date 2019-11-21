import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CompanyData } from 'src/app/model/CompanyModel';
import { DataService } from 'src/app/service/data.service';
import { UserData, PasswordData } from 'src/app/model/UserModel';

@Component({
  selector: 'app-create-company',
  templateUrl: './create-company.component.html',
  styleUrls: ['./create-company.component.css']
})
export class CreateCompanyComponent implements OnInit {

  constructor(private dataService: DataService) { }

  msg: string = ''
  companyGroup = new FormGroup({
    name: new FormControl('', [Validators.required]),
    description: new FormControl(''),
    address: new FormControl(''),
    username: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
  });

  ngOnInit() {
  }


  companyData: CompanyData;
  userData: CompanyData;
  onSubmit() {
    console.log("submit clicked");

    this.companyData = new CompanyData();
    this.companyData.name = this.companyGroup.get("name").value;
    this.companyData.address = this.companyGroup.get("address").value;
    this.companyData.description = this.companyGroup.get("description").value;

    let userData: UserData = new UserData();
    let passwordData: PasswordData = new PasswordData();

    passwordData.temporary = true;
    passwordData.type = "password";
    passwordData.value = this.companyGroup.get("password").value;

    userData.username = this.companyGroup.get("username").value;
    userData.email = this.companyGroup.get("email").value;
    userData.credentials = [passwordData];
    userData.groups = ["/manager_group"]
    userData.enabled = true;
    this.dataService.createUser(userData).subscribe(res => {
      console.log(res.username);
      this.companyData.adminid = res.id
      this.dataService.createCompany(this.companyData).subscribe(res => {
        this.msg = "Company created"
        this.companyGroup.reset();
      }, err => {
        console.log(err);

      })
    }, err => {
      console.log(err);

    })



    // this.dataService.createCompany(this.companyData).subscribe(res => {
    //   console.log("company Response");
    //   console.log(res);
    // },
    //   err => {
    //     console.log("Error");
    //     console.log(err);
    //   });
  }

}
