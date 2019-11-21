import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpParams, HttpClient } from '@angular/common/http';
import { UserData } from '../model/UserModel';
import { CompanyData } from '../model/CompanyModel';

@Injectable({
  providedIn: 'root'
})
export class DataService {


  baseUrl: string = "http://localhost:8181/auth/admin/realms/keycloak-permission/";
  keycloakLink: string = this.baseUrl + "users/";

  backendUrl: string = "http://localhost:8085/apis/"

  constructor(private http: HttpClient) { }

  getUserByUsername(username: string): Observable<UserData> {
    let params = new HttpParams();
    params = params.append('username', username);
    return this.http.get<UserData>(this.keycloakLink, { params: params });
  }

  createCompany(companyData: CompanyData) {
    let link: string = this.backendUrl + "company"
    return this.http.post(link, companyData)
  }

  getCompanies() {
    let link: string = this.backendUrl + "company"
    return this.http.get(link)
  }


  createUser(userData: UserData): Observable<UserData> {
    console.log("create user");
    console.log(userData);

    let link: string = this.backendUrl + "keycloak/users"
    return this.http.post<UserData>(link, userData)
  }

}
