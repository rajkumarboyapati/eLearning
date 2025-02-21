import { Component } from '@angular/core';
import { VedioServiceService } from '../vedio-service.service';

@Component({
  selector: 'app-vediocomponent',
  templateUrl: './vediocomponent.component.html',
  styleUrls: ['./vediocomponent.component.css']
})
export class VediocomponentComponent {
  selectedFile: File | null = null;
  videoUrl: string = '';
 
  constructor(private videoService: VedioServiceService) {}
 
  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }
 
  uploadVideo() {
    if (!this.selectedFile) return;
 
    const formData = new FormData();
    formData.append('title', 'Sample Video');
    formData.append('file', this.selectedFile);
 
    this.videoService.uploadVideo(formData).subscribe(response => {
      alert(response);
    }, error => {
      console.error('Upload failed', error);
    });
  }
 
  loadVideo(videoId: string) {
    // Convert the videoId from string to number
    const id = Number(videoId); // You can also use parseInt(videoId, 10)
    
    if (isNaN(id)) {
      console.error('Invalid video ID');
      return;
    }
  
    this.videoService.getVideo(id).subscribe(response => {
      const videoBlob = new Blob([response], { type: 'video/mp4' });
      this.videoUrl = URL.createObjectURL(videoBlob);
    }, error => {
      console.error('Error loading video', error);
    });
  }
  

}
