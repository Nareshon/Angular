import { Injectable } from '@angular/core';
import { user } from './user';
import { UserServiceService } from './user-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {


loggedinUser:number=-1;
  presentuser: string='';
  guardvalue: boolean;

authentication(user:user){
  this.loggedinUser=this.userservice.check(user);
  this.presentuser=user.username;
  return this.loggedinUser;
}

 getpresentUser(){
  return this.presentuser;
}

getLoggedinValue(){
  if(this.loggedinUser==1 || this.loggedinUser==0){
    this.guardvalue=true;
  }
  else{
    this.guardvalue=false;
  }
  return this.guardvalue;
}

logout(){
  this.loggedinUser=-1;
  console.log("after logout"+this.loggedinUser);
}

  constructor(public userservice:UserServiceService) { }
}
