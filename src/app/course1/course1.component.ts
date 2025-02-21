import { Component } from '@angular/core';
import { Instructor } from '../Instructor';
import { Course } from '../Course';

 
// interface Question {
//   questionName: string;
//   option1: string;
//   option2: string;
//   option3: string;
//   option4: string;
//   correctAnswer: string;
//   weightage: number;
// }
 
// interface Quiz {
//   quizName: string;
//   questionsList: Question[];
// }
 
// interface Video {
//   vedioName: string;
//   contentName: string; // Content name could represent the URL or file path
// }
 
// interface Module {
//   moduleName: string;
//   moduleContent: string;
//   quizRef: Quiz;
//   vedioRef: Video[];
// }
 
// interface Level {
//   levelName: string;
// }
 
// interface Course {
//   courseName: string;
//   instructorRef: Instructor[];
//   moduleList: Module[];
//   levelList: Level[];
// }

@Component({
  selector: 'app-course1',
  templateUrl: './course1.component.html',
  styleUrls: ['./course1.component.css']
})
export class Course1Component {
  // course: Course = {
  //   courseName: '',
  //   instructorRef:[],
  //   moduleList: [],
  //   levelList: [],
  //   category:{
  //     categoryId: 0,
  //     categoryName: undefined
  //   }
   
  // };
  course1:Course={
    courseId: 0,
    courseName: "",
    instructorRef: [
      {
        instructorId: 2,
        instructorName: "dff",
        instructorContact: "ffds",
        userRef: {
          userId: 6,
          password: "fghf",
          email: "fghfghh",
          role: "insrtuctor"
        }
      }
    ],
    moduleList: [
      {
        moduleId: 0,
        moduleName: "",
        moduleContent: "",
        materialType: "",
        materialName: "",
        quizRef: {
          quizId: 0,
          quizName: "",
          questionsList: [
            {
              questionId: 0,
              questionName: "",
              option1: "",
              option2: "",
              option3: "",
              option4: "",
              correctAnswer: "",
              weightage: 0
            }
          ]
        },
        vedioRef: [
          {
            vedioId: 0,
            vedioName: "",
            contentType: "",
            contentName: ""
          }
        ]
      }
    ],
    courseDuration: 0,
    levelList: [
      {
        levelId: 0,
        levelName: ""
      }
    ],
    category: {
      categoryId: 0,
      categoryName: ""
    }
  }
 
  // Add Instructor
  addInstructor() {
    this.course1.instructorRef.push({
      
        instructorId: 2,
        instructorName: "dff",
        instructorContact: "ffds",
        userRef: {
          userId: 6,
          password: "fghf",
          email: "fghfghh",
          role: "insrtuctor"
        }
      
    });
  }
 
  // Remove Instructor
  removeInstructor(index: number) {
    this.course1.instructorRef.splice(index, 1);
  }
 
  // Add Module
  addModule() {
    this.course1.moduleList.push(
      {
        moduleId: 0,
        moduleName: "",
        moduleContent: "",
        materialType: "",
        materialName: "",
        quizRef: {
          quizId: 0,
          quizName: "",
          questionsList: [
            {
              questionId: 0,
              questionName: "",
              option1: "",
              option2: "",
              option3: "",
              option4: "",
              correctAnswer: "",
              weightage: 0
            }
          ]
        },
        vedioRef: [
          {
            vedioId: 0,
            vedioName: "",
            contentType: "",
            contentName: ""
          }
        ]
      });
      
  }
 
  // Remove Module
  removeModule(index: number) {
    this.course1.moduleList.splice(index, 1);
  }
 
  // Add Question to a Module
  addQuestion(moduleIndex: number) {
    this.course1.moduleList[moduleIndex].quizRef.questionsList.push({
      questionId: 0,
      questionName: "",
      option1: "",
      option2: "",
      option3: "",
      option4: "",
      correctAnswer: "",
      weightage: 0
    });
  }
 
  // Remove Question from a Module
  removeQuestion(moduleIndex: number, questionIndex: number) {
    this.course1.moduleList[moduleIndex].quizRef.questionsList.splice(questionIndex, 1);
  }
 
  // Add Video to a Module
  addVideo(moduleIndex: number) {
    this.course1.moduleList[moduleIndex].vedioRef.push({
      vedioId: 0,
            vedioName: "",
            contentType: "",
            contentName: ""
    });
  }
 
  // Remove Video from a Module
  removeVideo(moduleIndex: number, videoIndex: number) {
    this.course1.moduleList[moduleIndex].vedioRef.splice(videoIndex, 1);
  }
 
  // Add Level
  addLevel() {
    this.course1.levelList.push({
      levelId: 0,
        levelName: ""
    });
  }
 
  // Remove Level
  removeLevel(index: number) {
    this.course1.levelList.splice(index, 1);
  }
 
  // Handle form submission
  onSubmit(form: any) {
    console.log(this.course1);
    // Handle the form submission logic here
  }

}
