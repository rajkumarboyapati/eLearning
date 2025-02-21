import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CompComponent } from './comp/comp.component';
import {HttpClientModule} from '@angular/common/http';
import { VediocomponentComponent } from './vediocomponent/vediocomponent.component';
import { FileComponent } from './file/file.component';
import { CertificatesComponent } from './certificates/certificates.component';
import { Course1Component } from './course1/course1.component'


@NgModule({
  declarations: [
    AppComponent,
    CompComponent,
    CompComponent,
    VediocomponentComponent,
    FileComponent,
    CertificatesComponent,
    Course1Component
  
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
