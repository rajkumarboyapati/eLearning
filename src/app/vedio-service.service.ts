import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VedioServiceService {

 
  private apiUrl = 'http://localhost:8084/vedio';
 
  constructor(private http: HttpClient
  ) { }
 
  uploadVideo(formData: FormData): Observable<any> {
return this.http.post(`${this.apiUrl}/upload`, formData, { responseType: 'text' });
  }
 
  getVideo(id: number): Observable<Blob> {
    return this.http.get(`${this.apiUrl}/${id}`, { responseType: 'blob' });
  }
}
