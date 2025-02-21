import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormArray, Validators } from '@angular/forms';
import { Course } from '../Course';
import { Instructor } from '../Instructor';
import { Service1Service } from '../service1.service';

@Component({
  selector: 'app-course-form',
  templateUrl: './comp.component.html',
  styleUrls: ['./comp.component.css']
})
export class CompComponent{

  // Define the form group with manually created form controls
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
  courseForm: FormGroup;

  constructor(private s:Service1Service){
    // Initialize the form controls and form group manually
    this.courseForm = new FormGroup({
      courseId: new FormControl(this.course1.courseId, Validators.required),
      courseName: new FormControl(this.course1.courseName, [Validators.required]),
      courseDuration: new FormControl(this.course1.courseDuration, Validators.required),
      category: new FormGroup({
        categoryId: new FormControl(this.course1.category.categoryId, Validators.required),
        categoryName: new FormControl(this.course1.category.categoryName, [Validators.required]),
      }),
      levelList: new FormArray([
        new FormGroup({
          levelId: new FormControl(this.course1.levelList[0].levelId, Validators.required),
          levelName: new FormControl(this.course1.levelList[0].levelName, [Validators.required]),
        })
      ]),
      moduleList: new FormArray([
        new FormGroup({
          moduleId: new FormControl(this.course1.moduleList[0].moduleId, Validators.required),
          moduleName: new FormControl(this.course1.moduleList[0], [Validators.required]),
          moduleContent: new FormControl(this.course1.moduleList[0].moduleContent, Validators.required),
          materialType: new FormControl(this.course1.moduleList[0].materialType, Validators.required),
          materialName: new FormControl(this.course1.moduleList[0].materialName, Validators.required),
          quizRef: new FormGroup({
            quizId: new FormControl(this.course1.moduleList[0].quizRef.quizId, Validators.required),
            quizName: new FormControl(this.course1.moduleList[0].quizRef.quizName, Validators.required),
            questionsList: new FormArray([
              new FormGroup({
                questionId: new FormControl(this.course1.moduleList[0].quizRef.questionsList[0].questionId, Validators.required),
                questionName: new FormControl(this.course1.moduleList[0].quizRef.questionsList[0].questionName, Validators.required),
                option1: new FormControl(this.course1.moduleList[0].quizRef.questionsList[0].option1, Validators.required),
                option2: new FormControl(this.course1.moduleList[0].quizRef.questionsList[0].option2, Validators.required),
                option3: new FormControl(this.course1.moduleList[0].quizRef.questionsList[0].option3, Validators.required),
                option4: new FormControl(this.course1.moduleList[0].quizRef.questionsList[0].option4, Validators.required),
                correctAnswer: new FormControl(this.course1.moduleList[0].quizRef.questionsList[0].correctAnswer, Validators.required),
                weightage: new FormControl(this.course1.moduleList[0].quizRef.questionsList[0].weightage, Validators.required),
              })
            ])
          }),
          vedioRef: new FormArray([
            new FormGroup({
              vedioId: new FormControl(this.course1.moduleList[0].vedioRef[0].vedioId, Validators.required),
              vedioName: new FormControl(this.course1.moduleList[0].vedioRef[0].vedioName, Validators.required),
              contentType: new FormControl(this.course1.moduleList[0].vedioRef[0].contentType, Validators.required),
              contentName: new FormControl(this.course1.moduleList[0].vedioRef[0].contentName, Validators.required),
            })
          ])
        })
      ])
    });
  }

  // Getters to access form controls easily
  get category() {
    return this.courseForm.get('category') as FormGroup;
  }

  get levelList() {
    return this.courseForm.get('levelList') as FormArray;
  }

  get moduleList() {
    return this.courseForm.get('moduleList') as FormArray;
  }

  get quizRef() {
    return this.moduleList.controls[0].get('quizRef') as FormGroup;
  }

  get questionsList() {
    return this.quizRef.get('questionsList') as FormArray;
  }

  get vedioRef() {
    return this.moduleList.controls[0].get('vedioRef') as FormArray;
  }

  // Method to submit form data
  onSubmit() {
    if (this.courseForm.valid) {
      console.log(this.courseForm.value);
    } else {
      console.log("Form is invalid");
    }
  }
  m:number=1;
  q:number=1;
  v:number=1;

  // Method to add new module dynamically
  addModule() {
    const moduleGroup = new FormGroup({
      moduleId: new FormControl('', Validators.required),
      moduleName: new FormControl('', Validators.required),
      moduleContent: new FormControl('', Validators.required),
      materialType: new FormControl('', Validators.required),
      materialName: new FormControl('', Validators.required),
      quizRef: new FormGroup({
        quizId: new FormControl('', Validators.required),
        quizName: new FormControl('', Validators.required),
        questionsList: new FormArray([
          new FormGroup({
            questionId: new FormControl('', Validators.required),
            questionName: new FormControl('', Validators.required),
            option1: new FormControl('', Validators.required),
            option2: new FormControl('', Validators.required),
            option3: new FormControl('', Validators.required),
            option4: new FormControl('', Validators.required),
            correctAnswer: new FormControl('', Validators.required),
            weightage: new FormControl('', Validators.required),
          })
        ])
      }),
      vedioRef: new FormArray([
        new FormGroup({
          vedioId: new FormControl('', Validators.required),
          vedioName: new FormControl('', Validators.required),
          contentType: new FormControl('', Validators.required),
          contentName: new FormControl('', Validators.required),
        })
      ])
    });

    this.moduleList.push(moduleGroup);
    this.resetIndices();
  }

  // Method to remove a module
  removeModule(index: number) {
    this.moduleList.removeAt(index);
    this.resetIndices();
  }
  addQuestions(){
    const questions=new FormGroup({
        questionId: new FormControl('', Validators.required),
        questionName: new FormControl('', Validators.required),
        option1: new FormControl('', Validators.required),
        option2: new FormControl('', Validators.required),
        option3: new FormControl('', Validators.required),
        option4: new FormControl('', Validators.required),
        correctAnswer: new FormControl('', Validators.required),
        weightage: new FormControl('', Validators.required),
      });
    this.questionsList.push(questions);

  }
  addVideo(){
     const vedio=new FormGroup([
      new FormGroup({
        vedioId: new FormControl('', Validators.required),
        vedioName: new FormControl('', Validators.required),
        contentType: new FormControl('', Validators.required),
        contentName: new FormControl('', Validators.required),
      })
    ]);
    this.vedioRef.push(vedio);
  }
  addcourse(){
    let course:Course=this.courseForm.value;
    this.s.addCourse(course).subscribe((c)=>this.course1=c);
  }
  resetIndices() {
    for (let i = 0; i < this.moduleList.controls.length; i++) {
      // Reset the moduleId
      this.moduleList.controls[i].patchValue({ moduleId: i + 1 });
  
      // Ensure that quizRef and questionsList are FormArrays
      const quizRef = this.moduleList.controls[i].get('quizRef') as FormGroup;
      const questionsList = quizRef?.get('questionsList') as FormArray;
  
      // Check if questionsList is a FormArray before using its length
      if (questionsList) {
        for (let j = 0; j < questionsList.controls.length; j++) {
          questionsList.controls[j].patchValue({ questionId: j + 1 });
        }
      }
    }
  
    for (let k = 0; k < this.vedioRef.controls.length; k++) {
      this.vedioRef.controls[k].patchValue({ vedioId: k + 1 });
    }
  }
  
}
