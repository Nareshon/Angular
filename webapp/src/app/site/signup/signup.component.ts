import { Component, OnInit } from '@angular/core';
import {FormGroup,Validators,FormControl} from '@angular/forms';
import { user } from '../user';
import { UserServiceService } from '../user-service.service';
import { Router } from '@angular/router';
import { MenuItemServiceService } from 'src/app/service/menu-item-service.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {


user:user={
  // username:'',userpassword:''
  username:'',
  firstname:'',
  lastname:'',
   password:'',
  confirm_password:''
}

  UserForms:FormGroup;


  constructor(public userservice:UserServiceService,public route:Router,public ser:MenuItemServiceService) { }

  ngOnInit() {


    this.UserForms=new FormGroup({

      'username':new FormControl('',[
        Validators.required
      ]),
      'firstname':new FormControl('',[
        Validators.required
      ]),
      'lastname':new FormControl('',[
        Validators.required
      ]),
      'password':new FormControl('',[
        Validators.required
      ]),
      'cpassword':new FormControl('',[
        Validators.required
      ]),
      




    })


    this.UserForms.get('username').valueChanges.subscribe(value=>this.user.username=value);
    this.UserForms.get('password').valueChanges.subscribe(value=>this.user.password=value);
    this.UserForms.get('firstname').valueChanges.subscribe(value=>this.user.firstname=value);
    this.UserForms.get('lastname').valueChanges.subscribe(value=>this.user.lastname=value);
    this.UserForms.get('cpassword').valueChanges.subscribe(value=>this.user.confirm_password=value);
    
    



  }






get username() {return this.UserForms.get('username');}
get firstname() {return this.UserForms.get('firstname');}
get lastname() {return this.UserForms.get('lastname');}
get password() {return this.UserForms.get('password');}
get cpassword() {return this.UserForms.get('cpassword');}






onSubmit(){
  // this.userservice.addUser(this.user);
  // this.route.navigateByUrl('login');
  console.log(this.user);
  
  this.ser.addUser(this.user).subscribe();


}




}
