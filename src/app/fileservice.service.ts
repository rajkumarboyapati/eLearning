import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FileserviceService {
  private baseUrl = 'http://localhost:8084/mat';
 
  constructor(private http: HttpClient) {}
 
  downloadFile(id: number) :Observable<any>{
    return this.http.get(this.baseUrl+"/"+id, { responseType: 'blob' });
  }

 
}
