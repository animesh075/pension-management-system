import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CalculatePensionComponent } from './components/calculate-pension/calculate-pension.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
// import { PensiondashboardComponent } from './components/pensiondashboard/pensiondashboard.component';
import { PensionerDetailsComponent } from './components/pensioner-details/pensioner-details.component';
import { PensionerDisburseComponent } from './components/pensioner-disburse/pensioner-disburse.component';
import { PensionerListComponent } from './components/pensioner-list/pensioner-list.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  {path:'',redirectTo:'/login',pathMatch:'full'},
  {path:'home',component:HomeComponent,pathMatch:'full'},
  {path:'login',component:LoginComponent,pathMatch:'full'},
  {path:'pensioner-lists',component:PensionerListComponent, pathMatch:'full', canActivate:[AuthGuard]},
  {path:'pensioner-details/:aadharNumber',component:PensionerDetailsComponent, pathMatch:'full', canActivate:[AuthGuard]},
  {path:'calculate-pension',component:CalculatePensionComponent,pathMatch:'full', canActivate:[AuthGuard]},
  {path:'calculate-pension/:aadharNumber',component:CalculatePensionComponent,pathMatch:'full', canActivate:[AuthGuard]},
  {path:'pensioner-disburse',component:PensionerDisburseComponent,pathMatch:'full', canActivate:[AuthGuard]},
  {path:"**",component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
