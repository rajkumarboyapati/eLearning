import { Component } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  addCourse:FormGroup;
  constructor(){
    this.addCourse= new FormGroup({
      courseId:new FormControl("",Validators.required),
      courseName:new FormControl("",[Validators.required,Validators.minLength(10)]),
      moduleList:new FormArray([this.createmoduleList()]),
      courseDuraion:new FormControl("",[Validators.required,Validators.min(40)]),
      categoryId:new FormControl("",Validators.required),
      categoryName:new FormControl(),
      LevelList:new FormArray([this.creatLevels()])


    })
    
  }
  createInstructor():FormGroup{
    return new FormGroup({
      InstructorId:new FormControl(),
      InstructorName:new FormControl(),
      InstructorContact:new FormControl(),
      UserRef:new FormArray([this.createuser()])
    })
  }
  createuser():FormGroup{
    return new FormGroup({
      UserId:new FormControl(),
      email:new FormControl(),
      password:new FormControl(),
      role:new FormControl()
    })
  }
  createmoduleList():FormGroup{
    return new FormGroup({
      moduleId:new FormControl(),
      moduleName:new FormControl(),
      moduleContent:new FormControl(),
      materialType:new FormControl(),
      materialName:new FormControl(),
      quizId:new FormControl(),
         quizName: new FormControl(),
         questionsList:new FormArray([this.createQuestions()]),  
      videoRef:new FormArray([this.createVideo()])

    })
  }
  // createQuiz():FormGroup{
  //   return new FormGroup({
  //     quizId:new FormControl(),
  //        quizName: new FormControl(),
  //        questionsList:new FormArray([this.createQuestions()]),
      

  //   })
  // }
  createQuestions():FormGroup{
    return new FormGroup({
            questionId: new FormControl(),
             questionName:new FormControl(),
             option1:new FormControl(),
             option2:new FormControl(),
             option3:new FormControl(),
             option4:new FormControl(),
             correctAnswer:new FormControl(),
             weightage:new FormControl()

    })
  }
  createVideo():FormGroup{
    return new FormGroup({
           vedioId: new FormControl(),
           vedioName:new FormControl(),
           contentType:new FormControl(),
           contentName:new FormControl()


    })
  }
  creatLevels():FormGroup{
    return new FormGroup({
      levelId: new FormControl(),
       levelName:new FormControl()
    })
  }
  get moduleList():FormArray{
    return this.addCourse.get("moduleList") as FormArray;
  }
  addModules():void{
    this.moduleList.push(this.createmoduleList());
  }
  removeModules(index:number):void{
    this.moduleList.removeAt(index);
  }
  get LevelList():FormArray{
    return this.addCourse.get("LevelList") as FormArray;
  }
  addLevels():void{
    this.LevelList.push(this.creatLevels());
  }
  removeLevls(index:number):void{
    this.LevelList.removeAt(index);
  }
  // get quizref():FormArray{
  //   return this.moduleList.get("quizref") as FormArray;
  // }
  // addQuiz():void{
  //   this.quizref.push(this.createQuiz());
  // }
  // removeQuiz(index:number):void{
  //   this.quizref.removeAt(index);
  // }
  get videoRef():FormArray{
    return this.moduleList.get("videoRef") as FormArray;
  }
  addVideos():void{
    this.videoRef.push(this.createVideo());
  }
  removevideo(index:number):void{
    this.videoRef.removeAt(index);
  }
  get questionsList():FormArray{
    return this.moduleList.get("questionsList") as FormArray;
  }
  addQuestion():void{
    this.questionsList.push(this.createQuestions());
  }
  removeQuestion(index:number):void{
    this.questionsList.removeAt(index);
  }
  onsubmit(){

  }
}
 
// import { Component } from '@angular/core';
// import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';

// @Component({
//   selector: 'app-root',
//   templateUrl: './app.component.html',
//   styleUrls: ['./app.component.css']
// })
// export class AppComponent {
//   addCourse: FormGroup;

//   constructor() {
//     this.addCourse = new FormGroup({
//       courseId: new FormControl('', Validators.required),
//       courseName: new FormControl('', [Validators.required, Validators.minLength(10)]),
//       moduleList: new FormArray([this.createModule()]),
//       courseDuraion: new FormControl('', [Validators.required, Validators.min(40)]),
//       categoryId: new FormControl('', Validators.required),
//       categoryName: new FormControl(),
//       LevelList: new FormArray([this.createLevel()])
//     });
//   }

//   // Create Module Form Group
//   createModule(): FormGroup {
//     return new FormGroup({
//       moduleId: new FormControl(),
//       moduleName: new FormControl(),
//       moduleContent: new FormControl(),
//       materialType: new FormControl(),
//       materialName: new FormControl(),
//       quizref: new FormArray([this.createQuiz()]),
//       videoRef: new FormArray([this.createVideo()])
//     });
//   }

//   // Create Quiz Form Group
//   createQuiz(): FormGroup {
//     return new FormGroup({
//       quizId: new FormControl(),
//       quizName: new FormControl(),
//       questionsList: new FormArray([this.createQuestion()])
//     });
//   }

//   // Create Question Form Group
//   createQuestion(): FormGroup {
//     return new FormGroup({
//       questionId: new FormControl(),
//       questionName: new FormControl(),
//       option1: new FormControl(),
//       option2: new FormControl(),
//       option3: new FormControl(),
//       option4: new FormControl(),
//       correctAnswer: new FormControl(),
//       weightage: new FormControl()
//     });
//   }

//   // Create Video Form Group
//   createVideo(): FormGroup {
//     return new FormGroup({
//       vedioId: new FormControl(),
//       vedioName: new FormControl(),
//       contentType: new FormControl(),
//       contentName: new FormControl()
//     });
//   }

//   // Create Level Form Group
//   createLevel(): FormGroup {
//     return new FormGroup({
//       levelId: new FormControl(),
//       levelName: new FormControl()
//     });
//   }

//   // Accessors for nested FormArrays
//   get moduleList(): FormArray {
//     return this.addCourse.get('moduleList') as FormArray;
//   }

//   get LevelList(): FormArray {
//     return this.addCourse.get('LevelList') as FormArray;
//   }

//   // Methods to handle dynamic adding/removing of Modules
//   addModule(): void {
//     this.moduleList.push(this.createModule());
//   }

//   removeModule(index: number): void {
//     this.moduleList.removeAt(index);
//   }

//   // Methods to handle dynamic adding/removing of Levels
//   addLevel(): void {
//     this.LevelList.push(this.createLevel());
//   }

//   removeLevel(index: number): void {
//     this.LevelList.removeAt(index);
//   }

//   // Methods to handle dynamic adding/removing of Quizzes
//   addQuiz(moduleIndex: number): void {
//     const quizArray = (this.moduleList.at(moduleIndex) as FormGroup).get('quizref') as FormArray;
//     quizArray.push(this.createQuiz());
//   }

//   removeQuiz(moduleIndex: number, quizIndex: number): void {
//     const quizArray = (this.moduleList.at(moduleIndex) as FormGroup).get('quizref') as FormArray;
//     quizArray.removeAt(quizIndex);
//   }

//   // Methods to handle dynamic adding/removing of Questions
//   addQuestion(moduleIndex: number, quizIndex: number): void {
//     const questionArray = ((this.moduleList.at(moduleIndex) as FormGroup).get('quizref') as FormArray).at(quizIndex).get('questionsList') as FormArray;
//     questionArray.push(this.createQuestion());
//   }

//   removeQuestion(moduleIndex: number, quizIndex: number, questionIndex: number): void {
//     const questionArray = ((this.moduleList.at(moduleIndex) as FormGroup).get('quizref') as FormArray).at(quizIndex).get('questionsList') as FormArray;
//     questionArray.removeAt(questionIndex);
//   }

//   // Methods to handle dynamic adding/removing of Videos
//   addVideo(moduleIndex: number): void {
//     const videoArray = (this.moduleList.at(moduleIndex) as FormGroup).get('videoRef') as FormArray;
//     videoArray.push(this.createVideo());
//   }

//   removeVideo(moduleIndex: number, videoIndex: number): void {
//     const videoArray = (this.moduleList.at(moduleIndex) as FormGroup).get('videoRef') as FormArray;
//     videoArray.removeAt(videoIndex);
//   }

//   // Submit the form data
//   onSubmit(): void {
//     console.log(this.addCourse.value);
//   }
// }

