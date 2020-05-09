import { Injectable } from '@angular/core';
import { user } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
user:user[]=[
  {username:'user',password:'user',firstname:'user',lastname:'user',confirm_password:'user'}
]



addUser(user:user){
  this.user.push(user);
  this.display();

}


check(user:user){
 
  
  for(let usercheck of this.user){
    console.log("usercheck is"+usercheck);
    
    if(usercheck.username==user.username && usercheck.password==user.password){
      return 1;
    }

    else if(user.username=="admin" && user.password=="admin"){
      return 0;
    }
    else {
  
      
     


    }



  }
  return -1;
}



display(){
  console.log(this.user);
}


  constructor() { }
}
