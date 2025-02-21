import { Modules } from "src/Modules";
import { Instructor } from "./Instructor";
import { Level } from "./Level";
import { Category } from "./Category";

export class Course{
    courseId: number;
    courseName: string;
    instructorRef: Instructor[]=[];
     
    moduleList: Modules[]=[];
    courseDuration: number;
    levelList: Level[]=[];
    category: Category=new Category();
    
  }
   