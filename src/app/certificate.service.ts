import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CertificateService {

  private apiUrl = 'http://localhost:8084/course/getcount';
 
  constructor(private http: HttpClient) {}
 
  // downloadCertificate(courseid: number, userName: string) {
  //   //const params = { courseid, userName };
  // //  this.http.get(this.apiUrl, { params, responseType: 'blob' }).subscribe(response => {
  // this.http.get(this.apiUrl+"/"+courseid+"/"+userName,{ responseType: 'blob' }).subscribe(response => {
  //     const blob = new Blob([response], { type: 'application/pdf' });
  //     const url = window.URL.createObjectURL(blob);
  //     const link = document.createElement('a');
  //     link.href = url;
  //     link.download = 'certificate.pdf';
  //     link.click();
  //     window.URL.revokeObjectURL(url);
  //   });
  // }
  downloadCertificate(courseId: number, userName: string) {
    this.http.get(this.apiUrl + "/" + courseId + "/" + userName, { responseType: 'blob' }).subscribe(response => {
      // Ensure the response is a Blob (PDF data)
      const blob = new Blob([response], { type: 'application/pdf' });
      const url = window.URL.createObjectURL(blob);
      
      // Create a link element and simulate a click to trigger download
      const link = document.createElement('a');
      link.href = url;
      link.download = 'certificate.pdf';
      link.click();
      
      // Clean up
      window.URL.revokeObjectURL(url);
    }, error => {
      alert('Error generating certificate.');
    });
  }
  
}
