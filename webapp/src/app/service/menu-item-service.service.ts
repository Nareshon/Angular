import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthenticationService } from './authentication.service';
import { foodItem } from '../Food/fooditem';
import { user } from '../site/user';

@Injectable({
  providedIn: 'root'
})
export class MenuItemServiceService {


addUser(user:user){
  const httpOptions ={
    headers:new HttpHeaders({
      'Content-type':'application/json',
      'Authorization' : 'Bearer '+this.authenticationService.getToken(),
    })
  };

  console.log(environment.baseUrl+"/users");
  

  return this.httpClient.post<void>(environment.baseUrl+"/users",user,httpOptions);

}





  removeCart(userName:string,id: number) {
    
    
    const httpOptions ={
      headers:new HttpHeaders({
        'Content-type':'application/json',
        'Authorization' : 'Bearer '+this.authenticationService.getToken(),
      })
    };
  
  
  console.log(userName+"ds"+id);
  console.log(environment.baseUrl+"/cart/"+userName+"/"+id);
  
   
    
  
    return this.httpClient.delete<void>(environment.baseUrl+"/cart/"+userName+"/"+id,httpOptions);
  
  



  }
  addtocart(userName:string,menuId:number) {


    const httpOptions ={
      headers:new HttpHeaders({
        'Content-type':'application/json',
        'Authorization' : 'Bearer '+this.authenticationService.getToken(),
      })
    };
  
  
  
  
  
    return this.httpClient.post<void>(environment.baseUrl+"/cart/"+userName+"/"+menuId,menuId,httpOptions);
  
  



    
  }

  showCart(name:string) {


    const httpOptions ={
      headers:new HttpHeaders({
        'Content-type':'application/json',
        'Authorization' : 'Bearer '+this.authenticationService.getToken(),
      })
    };
  
  
  
  
  
    return this.httpClient.get(environment.baseUrl+"/cart/show-cart/"+name,httpOptions);
  
  



    
  }





  updateFood(food: any) {
    throw new Error("Method not implemented.");
  }
  private baseUrl=environment.baseUrl;

  constructor(private httpClient:HttpClient,private authenticationService:AuthenticationService) { }

  private token:string=this.authenticationService.getToken();


updateFood1(food:any){

  const httpOptions ={
    headers:new HttpHeaders({
      'Content-type':'application/json',
      'Authorization' : 'Bearer '+this.authenticationService.getToken(),
    })
  };


console.log(food);


 return this.httpClient.put<void>(environment.baseUrl+'/menu-items',food,httpOptions);



}



  getAllMenuItems():Observable<any> {

    console.log(this.token);
     const httpOptions ={
       headers:new HttpHeaders({
         'Content-type':'application/json',
         'Authorization' : 'Bearer '+this.authenticationService.getToken(),
       })
     };
   

    return this.httpClient.get(environment.baseUrl+'/menu-items/all',httpOptions);



  }

  getMenuItem(name:string) {

    console.log(name);
    
    console.log(this.token);
    const httpOptions ={
      headers:new HttpHeaders({
        'Content-type':'application/json',
        'Authorization' : 'Bearer '+this.authenticationService.getToken(),
      })
    };
  
   this.httpClient.get(`${this.baseUrl}/menu-items/${name}`,httpOptions).subscribe(data=>console.log(data));
   

    return this.httpClient.get(`${this.baseUrl}/menu-items/${name}`,httpOptions);



  }





}
