import { Injectable } from '@angular/core';
import { foodItem } from './fooditem';
import { MenuItemServiceService } from '../service/menu-item-service.service';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  tempfood:string;
  fooddetails:foodItem[]=[
    // {id:1,name:'Pizza',price:149,category:'Main Course',freedelivery:true,url:'https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1355&q=80',active:true,dateoflaunch:new Date('02-02-2020')},
    // {id:2,name:'Burger',price:129,category:'Starters',freedelivery:false,url:'https://images.unsplash.com/photo-1547584370-2cc98b8b8dc8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1351&q=80',active:true,dateoflaunch:new Date('02-02-2019')},
    // {id:3,name:'Sandwich',price:88,category:'Main Course',freedelivery:true,url:'https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1353&q=80',active:false,dateoflaunch:new Date('02-02-2020')},
    // {id:4,name:'Frenchfries',price:57,category:'Starters',freedelivery:false,url:'https://images.unsplash.com/photo-1484009902830-a314db11070c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80',active:true,dateoflaunch:new Date('02-02-2019')},
    // {id:5,name:'Chocolate',price:200,category:'Dessert',freedelivery:true,url:'https://images.unsplash.com/photo-1461009312844-e80697a81cc7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1280&q=80',active:true,dateoflaunch:new Date('02-02-2019')},
    
  ];
  filteredfooddetails: foodItem[];
  






  getFoodItems(active:boolean,dateoflaunch:Date) {
    let filteredfood=this.fooddetails.filter(x=>x.active==active && x.dateoflaunch<dateoflaunch)

    return filteredfood;
  }

 
  search2(searchkey:any){

    

    console.log(this.fooddetails);

    this.filteredfooddetails=this.fooddetails.filter(x=>x.name.toLowerCase().indexOf(searchkey.toLowerCase())!==-1);
    return this.filteredfooddetails;
 }



  search1(searchkey:any,active:boolean,dateoflaunch:Date){


    console.log("fooddetailsinkk"+this.fooddetails);


     this.filteredfooddetails=this.fooddetails.filter(x=>x.active==active && x.dateoflaunch<dateoflaunch)
    this.filteredfooddetails=this.filteredfooddetails.filter(x=>x.name.toLowerCase().indexOf(searchkey.toLowerCase())!==-1);
    return this.filteredfooddetails;
  }


  getrespectedfood(itemname:string){
   
    for(let food of this.fooddetails){
     
      this.tempfood=":"+food.name;
      if(this.tempfood==itemname)
      {
        console.log(food);
        return food;
      }
    }


  }



  updatefood(food:foodItem){

    console.log("food is"+food);

    for(let f of this.fooddetails){
      if(f.id==food.id){
        f.name=food.name;
        f.active=food.active;
        f.price=food.price;
        f.freedelivery=food.freedelivery;
        f.dateoflaunch= new Date(food.dateoflaunch);
      }
    }

    for(let f of this.fooddetails){
      console.log("second");
      console.log(f);
    }




  }

  constructor(private ser:MenuItemServiceService) { }
}
