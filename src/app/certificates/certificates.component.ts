import { Component } from '@angular/core';
import { CertificateService } from '../certificate.service';

@Component({
  selector: 'app-certificates',
  templateUrl: './certificates.component.html',
  styleUrls: ['./certificates.component.css']
})
export class CertificatesComponent {
  userName: string = '';
  courseId:  number= 0;
 
  constructor(private certificateService: CertificateService) {}
 
  generateCertificate() {
    if (this.userName && this.courseId) {
      this.certificateService.downloadCertificate(this.courseId, this.userName);
    } else {
      alert("Please enter your name and course name.");
    }
  }
}
