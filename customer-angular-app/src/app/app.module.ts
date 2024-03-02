import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomersComponent } from './customers/customers.component';
import { ProductsComponent } from './products/products.component';
import {HttpClientModule} from "@angular/common/http";
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";


export function initializeKeycloak(keycloak: KeycloakService) {
  return () => {
    console.log('Initializing Keycloak...');

    return keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'security-part3-realm',
        clientId: 'customer-client-angular'
      },
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri: window.location.origin + '/assets/silent-check-sso.html'
      }
    });
  };
}
@NgModule({
  declarations: [
    AppComponent,
    CustomersComponent,
    ProductsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule
  ],
  providers: [
    /*{provide : APP_INITIALIZER, deps : [KeycloakService],useFactory : initializeKeycloak, multi : true}*/
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      deps: [KeycloakService],
      multi: true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
