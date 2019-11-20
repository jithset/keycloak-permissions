import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { CompanyComponent } from './components/company/company.component';
import { HomeComponent } from './components/home/home.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { CreateCompanyComponent } from './components/company/create-company/create-company.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent,
    data: { animation: 'hero' },
    children: [
      {
        path: 'company',
        component: CompanyComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'company/create',
        component: CreateCompanyComponent,
        canActivate: [AuthGuard],
      },
    ]
  },

  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes),],
  exports: [RouterModule]
})
export class AppRoutingModule { }
