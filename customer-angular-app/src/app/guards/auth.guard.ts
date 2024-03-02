import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {

  constructor(
      private readonly router: Router,
      private readonly keycloak: KeycloakService,
  ) {
  }

  canActivate(
      route: ActivatedRouteSnapshot,
      state: RouterStateSnapshot,
  ): boolean | UrlTree {
    console.log('AuthGuard canActivate called');
    const data = route.data as { roles?: string[] };
    const requiredRoles = data.roles;

    if (!this.keycloak.isLoggedIn()) {
      // Redirect to login page if not authenticated
      return this.router.parseUrl('/customers');
    }

    // Check roles if needed
    if (requiredRoles && !requiredRoles.some(role => this.keycloak.isUserInRole(role))) {
      // Redirect to access denied page if roles are not satisfied
      //return this.router.parseUrl('/access-denied');
      return this.router.parseUrl('/customers');
    }

    return true;
  }
}
