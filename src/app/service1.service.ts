import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from './Course';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
  url:string="http://localhost:8084";

  constructor(private h:HttpClient) { 

  }
  public addCourse(course:Course):Observable<any>{
    return this.h.post(this.url+"/course/addcourse",course,{responseType:"json"});
  }
  
}
