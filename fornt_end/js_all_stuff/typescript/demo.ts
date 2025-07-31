//hello world of ts
// function printName(userName:string){
//     console.log(`the details of person name ${userName}`)
// }

// printName('raj')

//data type in ts

// let isDone:boolean =true
// isDone='abc'

// let firstname: string='raj'

// let firstname: any;
// firstname=12;



//fuction that take a number array and give me some

// function giveMeSome(arr: Array<number>): number{
//      let sum: number = 0;   
//     sum = arr.reduce((x, y) => x + y, 0);
//     return sum;
// }
// //how to declare arrary
// let myarr: Array<number>=[4,6,7]
// let sum=giveMeSome(myarr);
// console.log(sum)

//enum ? named constant
// let state:number=1
// enum Directions  {UP, DOWN, LEFT, RIGHT}
// if(state==Directions.DOWN){
//     console.log(`this is true`)
// }

//what is interface in ts? use case  * angular classes
//print person : json {firstname:'raj',lastName:'gupta'}

// interface IPerson{
//     firstName: string;
//     lastName ?:string ; // lastName is optional value
// }

// let ob:IPerson={
//     firstName:'raj'
// }

// let ob2:IPerson={
//     firstName:'raj',
//     lastName:'gupta'
// }

// function printPersonDetails(ob: IPerson):void{
//     console.log(`the person name is ${ob.firstName} and lastname is ${ob.lastName}`)
// }

// let dummyOb={
//     firstName:'raj',
//     lastName:'gupta'
// }

// printPersonDetails(dummyOb)


//how to create class in ts
// class Employee{

//     private firtName: string;
//       private lastName: string;

//     constructor(firtName:string, lastName: string){
//          this.firtName=firtName
//          this.lastName=lastName
//     }
// }
//record in java ?

// class Employee{
//     constructor(private firtName:string, private lastName: string){}
// }

//let e: Employee=new Employee('raj','gupta');


// interface User {
//   name: string;
//   address?: {
//     city?: string;
//     zipCode?: string;
//   };
// }

// const user1: User = {
//   name: "Alice",
// };

// console.log(user1?.address?.city)

//what is optional chaining ? to exception

// interface User {
//   name: string;
//   address?: {
//     city?: string;
//     zipCode?: string;
//   };
// }

// const user1: User = {
//   name: "raj",
// };
// console.log(user1?.address?.city)

// interface Logger {
//   log?: () => void; // `log` is an optional method
// }

// const logger: Logger = {
//   //log: () => console.log("Logging...") // you can comment this to test the 'undefined' case
// };

// logger.log?.(); // Safely call `log()` only if it's defined

// Nullish Coalescing (??)
// ------------------------------------
// Use ?? to provide default values:

const appConfig = {
  user: {
    settings: {
      theme: null
    }
  }
};
const theme = appConfig.user?.settings?.theme ?? "foo";
console.log(theme)