import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
// public loginStatusSubject = new Subject<boolean>();
// http://localhost:8765/AUTHORIZATIONSERVICE/v2/api-docs

base_url = "http://localhost:8060/api/auth"
  // base_url = "http://pms-microservices-lb-1484324810.us-east-1.elb.amazonaws.com/api/auth"

  constructor(private http: HttpClient) { }

  // generate token

  public generateToken(loginData:any){
    return this.http.post(`${this.base_url}/authenticate`,loginData);
  }

  public loginUser(token: string,userId: string){
    localStorage.setItem("token",token);
    localStorage.setItem("userId",userId);
    return true;
  }

  // public getCurrentUser(){
  //   let userId = localStorage.getItem("userId");
  //   return userId;
  // }

  // isLogin: user is logged in or not
  public isLoggedIn(){
    let tokenStr = localStorage.getItem("token");
    if(tokenStr==undefined || tokenStr == '' || tokenStr == null){
      return false;
    }else{
      return true;
    }
  }

  // logout : remove token from local storage
  public logout(){
    localStorage.removeItem("token");
    return true;
  }

  // get token
  public getToken(){
    return localStorage.getItem('token');
  }

  // set userDetail
  public setUser(userId:any){
    localStorage.setItem('user',JSON.stringify(userId));
  }

  // get user
  public getUser(){
    let userStr = localStorage.getItem("user");
    if(userStr!=null){
      return JSON.parse(userStr);
    }else{
      this.logout();
      return null;
    }
  }

}
