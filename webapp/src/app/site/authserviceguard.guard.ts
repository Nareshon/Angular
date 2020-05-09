import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthServiceService } from './auth-service.service';
import { AuthenticationService } from '../service/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceguardGuard implements CanActivate {
  constructor(public service :AuthServiceService,public route:Router,public aut:AuthenticationService){}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

      // if(this.service.getLoggedinValue()){
      //   return true;
      // }
      // else{
      //   this.route.navigateByUrl('/login');
      //   return false;
      // }


      if(this.aut.getUserDetails()){
        return true;
      }
      else {
        
        this.route.navigateByUrl('/login');
         return false;
      }

   
  }
}
