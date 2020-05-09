import { Component, OnInit } from '@angular/core';
import { user } from '../user';
import { AuthServiceService } from '../auth-service.service';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

temp:number;
user:user={
  username:'user',password:'user',firstname:'user',lastname:'user',confirm_password:'user'
}
  inval: boolean;
  error: boolean=true;

onSubmit(){
 

  console.log(this.user.username+"dsa"+this.user.password);
  

  let authResult =  this.auth.authenticate(this.user.username,this.user.password);
 
  authResult.subscribe(
    data=>{
      console.log("Authentication Successful");
      this.auth.setToken(data.token);
      this.auth.setName1(data.user);
      console.log(data.user);
      this.auth.setName(data.role);
      console.log(data.role);
      this.route.navigateByUrl('food-search');
    },
    err=>{
      console.log("Hello")
      if(err.statuscode == 401){
        this.error=false;
      }
    }
  );







  // console.log("this.user is",this.user);


  // //this.authservice.authentication(this.user);
  // this.temp=this.authservice.authentication(this.user);
  // console.log("this.temp is",this.temp);

  // if(this.temp==-1){
  //     this.inval=true;
  // }
  // else{
  // this.route.navigateByUrl('food-search');
  // }
}

  constructor(public authservice:AuthServiceService,public route:Router,public auth:AuthenticationService) { }

  ngOnInit() {
    this.inval=false;
  }

}
