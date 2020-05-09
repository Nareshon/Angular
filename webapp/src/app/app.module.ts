import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FoodItemInfoComponent } from './Food/food-item-info/food-item-info.component';
import { FoodMenuComponent } from './Food/food-menu/food-menu.component';
import { FoodSearchComponent } from './Food/food-search/food-search.component';
import {FormsModule} from '@angular/forms';
import{ReactiveFormsModule} from '@angular/forms'
import { CartComponent } from './shopping/cart/cart.component';
import { FoodItemEditComponent } from './Food/food-item-edit/food-item-edit.component';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import {HttpClientModule} from '@angular/common/http';
@NgModule({
  declarations: [
    AppComponent,
    FoodItemInfoComponent,
    FoodMenuComponent,
    FoodSearchComponent,
    CartComponent,
    FoodItemEditComponent,
    SignupComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
