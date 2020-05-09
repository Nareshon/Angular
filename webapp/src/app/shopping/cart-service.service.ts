import { Injectable } from '@angular/core';
import { Cart } from './cart';
import { foodItem } from '../Food/fooditem';

@Injectable({
  providedIn: 'root'
})
export class CartServiceService {

cart1:Cart={
  total:0,
  fooditem:[]
}


clearcart(){
  this.cart1={
    fooditem:[],
    total:0
  }
}



getCartItems(){
 

  return this.cart1.fooditem;
}
getTotal(){
  this.cart1.total=0;
for(let c of this.cart1.fooditem){
  this.cart1.total=this.cart1.total+c.price;
}
return this.cart1.total;
}

addtocart(food:foodItem){
    this.cart1.fooditem.push(food);
  
}
deletefromcart(name:string){

 const index= this.cart1.fooditem.findIndex(food=>food.name==name);
 const itemToRemove=this.cart1.fooditem.splice(index,1)[0];
 this.cart1.total=this.cart1.total-itemToRemove.price;
console.log(this.cart1.total);
}


  constructor() { }
}
