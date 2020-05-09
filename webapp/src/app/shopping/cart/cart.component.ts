import { Component, OnInit } from '@angular/core';
import { CartServiceService } from '../cart-service.service';
import { Cart } from '../cart';
import { foodItem } from 'src/app/Food/fooditem';
import { AuthServiceService } from 'src/app/site/auth-service.service';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';
import { MenuItemServiceService } from 'src/app/service/menu-item-service.service';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  presentname:string='';
  f:any;
  foodd:foodItem[];

  data:any;
  

  total:number;
 
  constructor(public cartservice:CartServiceService,public authservice:AuthServiceService,public route:Router,public ser:MenuItemServiceService,public aut:AuthenticationService) { }

  removefromcart(id:number){
    // this.cartservice.deletefromcart(name);
    // this.total;
   console.log("in removezzz");
   
    this.ser.removeCart(this.aut.getName1(),id).subscribe(()=>this.ser.showCart(this.aut.getName1()).subscribe(data1=>{
      
      this.data=data1;
      
      // console.log("cart is"+data);
      // this.f=data.menuItemList;
      // console.log(this.f);
      // this.foodd=this.f;
      // console.log(this.foodd);
      // this.total=data.total;
      

    }));
    
    

  }

  ngOnInit() {

  
    console.log(this.aut.getName1());
    

    this.ser.showCart(this.aut.getName1()).subscribe(data1=>{


      this.data=data1;
      //console.log("cart is"+data);
     // this.f=data.menuItemList;
      console.log(this.f);
      this.foodd=this.f;
      //console.log(this.foodd.name);
      //this.total=data.total;
      
    });
    
    
    // this.foodd=this.cartservice.getCartItems();
    
    this.presentname=this.aut.getName1();
  }

  logout(){
    this.authservice.logout();
    this.cartservice.clearcart();
    this.route.navigateByUrl('login');
  }


}
