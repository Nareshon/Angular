import { Injectable } from '@angular/core';
import { UserServiceService } from '../site/user-service.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private authenticationApiUrl = 'http://localhost:8083/authentication-service/authenticate';
  private token: string;
  name1: string="anon";
name:string;
  constructor(private httpClient: HttpClient) { }



  getUserDetails(){
    if(this.name1=="admin" || this.name1=="anon"){

      return false;

    }
    else{
      return true;
    }
  }






  authenticate(user: string, password: string): Observable<any> {


    let credentials = btoa(user + ':' + password);
    let headers = new HttpHeaders();
    console.log("credentials: " + credentials);

    headers = headers.set('Authorization', 'Basic ' + credentials);
    return this.httpClient.get(this.authenticationApiUrl, { headers })




  }



  public setToken(token: string) {
    this.token = token;
  }
  public getToken() {
    return this.token;
  }

  public setName(name:string){
    this.name=name;
  }

  public getName() {
    return this.name;
  }


  
  public setName1(name:string){
    this.name1=name;
  }

  public getName1() {
    return this.name1;
  }
public clear(){
  this.name="";
}


public logout(){
  this.name="";
  this.token="";
}



}
