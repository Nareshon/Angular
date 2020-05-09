import { Component, OnInit } from '@angular/core';
import { foodItem } from '../fooditem';
import { FoodService } from '../food.service';
import { AuthServiceService } from 'src/app/site/auth-service.service';
import { Router } from '@angular/router';
import { CartServiceService } from 'src/app/shopping/cart-service.service';
import { MenuItemServiceService } from 'src/app/service/menu-item-service.service';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-food-search',
  templateUrl: './food-search.component.html',
  styleUrls: ['./food-search.component.css']
})
export class FoodSearchComponent implements OnInit {

  active:boolean=true;
  dateoflaunch:Date=new Date();

  presentuser:string=this.aut.getName1();

 check:number=0; 
  admincheck:boolean=false;
  customercheck:boolean=false;
  ancheck:boolean=true;
  


  fooddetails:foodItem[];
  
  datetoday:Date=new Date();
  filtered:foodItem[];
  searchkey:any='';
  filteredfooddetails:foodItem[];
  cname: string;
  
    constructor(public foodservice:FoodService,public authService:AuthServiceService,public route:Router,public cartservice:CartServiceService,public ser:MenuItemServiceService,public aut:AuthenticationService) {
  
     
     }
  search(){
    

    this.ser.getAllMenuItems().subscribe(data=>{this.filteredfooddetails=data;this.filteredfooddetails=this.filteredfooddetails.filter(x=>x.name.toLowerCase().indexOf(this.searchkey.toLowerCase())!==-1);});





    // if(this.check==0){
  
     

    //   this.filteredfooddetails=this.filteredfooddetails.filter(x=>x.name.toLowerCase().indexOf(this.searchkey.toLowerCase())!==-1);
     
    // }
    // else if(this.check==1){
    //   this.filteredfooddetails=this.filteredfooddetails.filter(x=>x.name.toLowerCase().indexOf(this.searchkey.toLowerCase())!==-1);
    //   console.log("customer-check"+this.filteredfooddetails);
    // }

    // else {
    //   this.filteredfooddetails=this.filteredfooddetails.filter(x=>x.name.toLowerCase().indexOf(this.searchkey.toLowerCase())!==-1);
    //   console.log(this.filteredfooddetails);
      
    // }








  }



logout(){
  this.aut.logout();
  
  this.route.navigateByUrl('login');
}


    ngOnInit() {
     


      console.log(this.presentuser);
      


      this.ser.getAllMenuItems().subscribe(data=>{this.filteredfooddetails=data});


     
      this.cname=this.aut.getName();

      console.log(this.cname);
      

      if(this.cname=="ADMIN"){
        this.admincheck=true;
        this.ancheck=false;
      }
      
      else if(this.cname=="USER"){
        this.customercheck=true;
          this.ancheck=false;
      }
      else{

      }

      

      // console.log("in food search"+this.authService.loggedinUser);
      // this.check=this.authService.loggedinUser;
      // if(this.check==0){
      //   console.log("in this.check loop")
      //   this.filteredfooddetails=this.foodservice.search2(this.searchkey);
      //   console.log(this.filteredfooddetails);
      // }
      // else if(this.check==1){
      //   this.filteredfooddetails=this.foodservice.search1(this.searchkey,this.active,this.dateoflaunch);
       
      // }
      // else{
      //   this.filteredfooddetails=this.foodservice.search1(this.searchkey,this.active,this.dateoflaunch);
      // }



      // if(this.check==0){
      //   this.admincheck=true;
      //   this.ancheck=false;
      // }
      // else if(this.check==1){
      //   this.customercheck=true;
      //   this.ancheck=false;
      // }
      // else {
      //   this.ancheck=true;
      // }




    }
}
