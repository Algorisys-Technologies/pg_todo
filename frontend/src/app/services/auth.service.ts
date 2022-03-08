import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenStorageService } from './token-storage.service';

const AUTH_API_REGISTER = '/api/user/register';
const AUTH_API_LOGIN = '/api/user/login';



@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient,
    private token: TokenStorageService) { }

  login(userData):Observable<any> {
    return this.http.post(AUTH_API_LOGIN, userData);
  }

  register(userData):Observable<any> {
    return this.http.post(AUTH_API_REGISTER, userData);
  }


}