import { Quiz } from "./app/Quiz";
import { Vedio } from "./app/Vedio";
export class Modules{

      moduleId: number
      moduleName:string;
      moduleContent: string;
      materialType: string;
      materialName:string;
      quizRef: Quiz=new Quiz();
      vedioRef: Vedio[]=[];
    }