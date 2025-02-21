import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompComponent } from './comp/comp.component';
import { VediocomponentComponent } from './vediocomponent/vediocomponent.component';
import { FileComponent } from './file/file.component';
import { CertificatesComponent } from './certificates/certificates.component';
import { Course1Component } from './course1/course1.component';

const routes: Routes = [
  {
    path:"comp",
    component:CompComponent
  },
  {
    path:"video",
    component:VediocomponentComponent
  },
  {
    path:"file",
    component:FileComponent
  },
  {
    path:"",
    component:CertificatesComponent
  },
  {
    path:"c1",
    component:Course1Component

  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
