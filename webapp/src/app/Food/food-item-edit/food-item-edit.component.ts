import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import { Cart } from 'src/app/shopping/cart';
import { foodItem } from '../fooditem';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodService } from '../food.service';
import { AuthServiceService } from 'src/app/site/auth-service.service';
import { CartServiceService } from 'src/app/shopping/cart-service.service';
import { MenuItemServiceService } from 'src/app/service/menu-item-service.service';
import { AuthenticationService } from 'src/app/service/authentication.service';
@Component({
  selector: 'app-food-item-edit',
  templateUrl: './food-item-edit.component.html',
  styleUrls: ['./food-item-edit.component.css']
})
export class FoodItemEditComponent implements OnInit {
Forms:FormGroup;


item_name=this.route.snapshot.paramMap.get("id");


  






food:any;

// food:foodItem=this.foodservice.getrespectedfood(this.item_name);
  saveddetails: boolean=false;


  logout(){
    // this.authService.logout();
    
    
    this.aut.logout();    
    this.routee.navigateByUrl('login');
  }



  constructor(private aut:AuthenticationService, private route:ActivatedRoute,public foodservice:FoodService,public authService:AuthServiceService,public routee:Router,public cartservice:CartServiceService,public menuservice:MenuItemServiceService) { }

  ngOnInit() {
   let itemId=(Number) (this.item_name);

    this.menuservice.getMenuItem(this.item_name).subscribe(data=> {
      this.food=data;
      console.log(data);
      this.Forms=new FormGroup({

        'name':new FormControl(this.food.name,[
          Validators.required
        ]),
      
        'price':new FormControl(this.food.price,[
          Validators.required
        ]),
      
        'category':new FormControl(this.food.category,[
          Validators.required
        ]),
        'dateOfLaunch':new FormControl(this.food.dateOfLaunch,[
          Validators.required
        ]),
        'active':new FormControl(this.food.active,[
          Validators.required
        ]),
      
        'freeDelivery':new FormControl(this.food.freeDelivery,[
          Validators.required
        ])
        
      
      
      
      })
      
      
      this.Forms.get('name').valueChanges.subscribe(value=>this.food.name=value);
       this.Forms.get('price').valueChanges.subscribe(value=>this.food.price=value);
      this.Forms.get('category').valueChanges.subscribe(value=>this.food.category=value);
      this.Forms.get('dateOfLaunch').valueChanges.subscribe(value=>this.food.dateOfLaunch=value);
      this.Forms.get('active').valueChanges.subscribe(value=>this.food.active=value);
      this.Forms.get('freeDelivery').valueChanges.subscribe(value=>this.food.freeDelivery=value);
    });








  }











  onSubmit(){
    console.log("in edit file"+this.food);


    this.menuservice.updateFood1(this.food).subscribe();
    console.log(this.food);
    


    // this.foodservice.updatefood(this.food);
    // this.saveddetails=true;
  }

  
 get name() {return this.Forms.get('name');}
 get price() {return this.Forms.get('price');}
 get dateOfLaunch() {return this.Forms.get('dateOfLaunch');}
 get category() {return this.Forms.get('category');}
get active() {return this.Forms.get('active');}
get freeDelivery() { return this.Forms.get('freeDelivery');}






}
