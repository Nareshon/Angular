import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import{CartComponent} from './shopping/cart/cart.component';
import { FoodSearchComponent } from './Food/food-search/food-search.component';
import { FoodItemEditComponent } from './Food/food-item-edit/food-item-edit.component';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { FoodMenuComponent } from './Food/food-menu/food-menu.component';
import { AuthserviceguardGuard } from './site/authserviceguard.guard';
const routes: Routes = [
{path:'cart',component:CartComponent ,canActivate:[AuthserviceguardGuard]},
{path:'food-search',component:FoodSearchComponent},
{path:'food-item-edit',component:FoodItemEditComponent},
{path:'food-item-edit/:id',component:FoodItemEditComponent},
{path:'signup',component:SignupComponent},
{path:'login',component:LoginComponent},
{path:'food-menu',component:FoodMenuComponent},
{path:'',redirectTo:'food-search',pathMatch:'full'}





];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
