import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FileserviceService } from '../fileservice.service';

@Component({
  selector: 'app-file',
  templateUrl: './file.component.html',
  styleUrls: ['./file.component.css']
})
export class FileComponent {
  selectedFile: File | null = null;
 
  constructor(private http: HttpClient,private fileservice:FileserviceService) {}
 
  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }
 
  uploadFile() {
    if (!this.selectedFile) return;
 
    const formData = new FormData();
    formData.append('file', this.selectedFile);
 
    this.http.post('http://localhost:8084/mat/upload', formData)
      .subscribe(response => {
        console.log('File uploaded successfully', response);
      }, error => {
        console.error('Upload failed', error);
      });
  }
 
 
 
 
  downloadFile(id: number) {
    this.fileservice.downloadFile(id).subscribe((blob) => {
      const url = window.URL.createObjectURL(blob);
      const a = document.createElement('a');
      a.href = url;
      a.download = 'downloaded-file1.docx'; // Change based on file type
      a.click();
      window.URL.revokeObjectURL(url);
    });
  }

}
