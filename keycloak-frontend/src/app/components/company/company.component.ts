import { Component, OnInit } from '@angular/core';
import { slideInAnimation } from 'src/app/animation/animation';
import { DataService } from 'src/app/service/data.service';
import { CompanyData } from 'src/app/model/CompanyModel';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  constructor(private dataService: DataService) { }

  companyList: any;
  ngOnInit() {
    this.getCompanys()
  }

  getCompanys() {
    this.dataService.getCompanies().subscribe(res => {
      console.log(res);
      this.companyList = res
    }, err => {
      console.log(err);
    })
  }

}
