import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpParams, HttpClient } from '@angular/common/http';
import { UserData } from '../model/UserModel';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  baseUrl: string = "http://localhost:8181/auth/admin/realms/keycloak-permission/";
  keycloakLink: string = this.baseUrl + "users/";

  constructor(private http: HttpClient) { }

  getUserByUsername(username: string): Observable<UserData> {
    let params = new HttpParams();
    params = params.append('username', username);
    return this.http.get<UserData>(this.keycloakLink, { params: params });
  }

}
