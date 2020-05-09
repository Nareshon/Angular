import { Component, OnInit, Input } from '@angular/core';
import { foodItem } from '../fooditem';
import { FoodService } from '../food.service';
import { CartServiceService } from 'src/app/shopping/cart-service.service';
import { Cart } from 'src/app/shopping/cart';
import { AuthServiceService } from 'src/app/site/auth-service.service';
import { MenuItemServiceService } from 'src/app/service/menu-item-service.service';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-food-menu',
  templateUrl: './food-menu.component.html',
  styleUrls: ['./food-menu.component.css']
})
export class FoodMenuComponent implements OnInit {
active:boolean=true;
dateOfLaunch:Date=new Date();

fooddetails:foodItem[]=this.foodservice.getFoodItems(this.active,this.dateOfLaunch);

check:number;


datetoday:Date=new Date();

@Input()
fooddetails1:any;



  admincheck: boolean=false;
  customercheck: boolean=false;
  ancheck: boolean=true;
  cname: any;

  constructor(public foodservice:FoodService,public cartservice:CartServiceService,public authservice:AuthServiceService,public ser:MenuItemServiceService,public aut:AuthenticationService) { }

  ngOnInit() {


    console.log(this.fooddetails);

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












    // const x=this.ser.getAllMenuItems();
    // x.subscribe(data=>{this.fooddetails1=data})

    
    // this.check=this.authservice.loggedinUser;
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


    console.log(this.admincheck+"customercheck"+this.customercheck+"an-check"+this.ancheck);



  }



  addtocart1(addtocartfood2:foodItem){
    

    console.log(this.aut.getName1());

    

    // this.ser.addtocart(1,addtocartfood2.id).subscribe();
    this.ser.addtocart(this.aut.getName1(),addtocartfood2.id).subscribe();
    
    
    
    // console.log("inside");
    // this.cartservice.addtocart(addtocartfood2);

  }



}
