import { NgModule, DoBootstrap } from '@angular/core';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { AppComponent } from './app.component';
import { environment } from 'src/environments/environment';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { TestComponent } from './components/test/test.component';
import { AuthGuard } from './auth.guard';

const keycloakService = new KeycloakService();

@NgModule({

  declarations: [
    AppComponent,
    TestComponent
  ],
  imports: [KeycloakAngularModule,
    BrowserModule,
    AppRoutingModule],
  providers: [
    AuthGuard,
    {
      provide: KeycloakService,
      useValue: keycloakService
    }
  ],
  entryComponents: [AppComponent]
})
export class AppModule implements DoBootstrap {
  async ngDoBootstrap(app) {
    const { keycloakConfig } = environment;

    try {
      await keycloakService.init({
        config: keycloakConfig,
        initOptions: {
          onLoad: 'login-required',
          checkLoginIframe: false
        },
        enableBearerInterceptor: true,
        bearerExcludedUrls: ['/profile', '/clients/public']
      });
      app.bootstrap(AppComponent);
    } catch (error) {
      console.error('Keycloak init failed', error);
    }
  }
}
