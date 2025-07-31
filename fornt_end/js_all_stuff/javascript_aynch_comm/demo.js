//what is callback : a method is passed into a another method call

//a method is return an another method ... call back

//event handing.. if very nested ... callback hell 

// function greet(name, callback){
//     callback(name)
// }
 
// greet('raj', name=>console.log(name))

//calculator : ocp

// function add(a, b){
//     return a+b;
// }
// function mul(a, b){
//     return a*b;
// }
// function divide(a, b){
//     return a/b;
// }
// //ocp 
// function process(a, b , callback){
//     return callback(a, b)
 
// }
// let result= process(2,3, add)
// console.log(result)

// setTimeout(() => {
//   console.log("Task 1");
//   setTimeout(() => {
//     console.log("Task 2");
//     setTimeout(() => {
//       console.log("Task 3");
//     }, 1000);
//   }, 1000);
// }, 1000);

// console.log('start')
// setTimeout(()=>{
//     console.log('inside settimeout method')
// },0)
// console.log('end')

//network 
// let promiseToCleanTheRoom=new Promise(function(resolved, reject){
// 	//cleanning the room
// 	let isClean=true;
// 	if(isClean){
// 		resolved('clean');
// 	}else{
// 		reject('not clean');
// 	}
// });
// promiseToCleanTheRoom.then(res=> console.log(res)).catch(rej=> console.log(rej))

// promiseToCleanTheRoom.then(function(res){
//     console.log(res)
// }).catch(function(rej){
//     console.log(rej)
// })

// function cleanRoom() {
//   return Promise.resolve("Cleaned Room");
// }

// function removeGarbage(previousTask) {
//      return Promise.reject('why hell me')
// //   return Promise.resolve(previousTask + " → Garbage Removed");
// }

// function winIceCream(previousTask) {
//   return Promise.resolve(previousTask + " → Won Ice Cream");
// }
// cleanRoom()
// .then(removeGarbage)
// .then(winIceCream)
// .then(res=> console.log(res))
// .catch(err=> console.log(err))

console.log('start')
function step1() {
  return new Promise((resolve) => setTimeout(() => resolve("Step 1"), 1000));
}
function step2(data) {
  return new Promise((resolve) => setTimeout(() => resolve(data + " → Step 2"), 1000));
}
function step3(data) {
  return new Promise((resolve) => setTimeout(() => resolve(data + " → Step 3"), 1000));
}

async function runSteps() {
  try {
    const res1 = await step1();
    const res2 = await step2(res1);
    const res3 = await step3(res2);
    console.log(res3);
  } catch (err) {
    console.error("Error occurred:", err);
  }
}
console.log('end')
//runSteps();
// step1()
//   .then(step2)
//   .then(step3)
//   .then(console.log)
//   .catch(console.error);
// console.log('done')
  
async function runSteps() {
  try {
    const res1 = await step1();
    const res2 = await step2(res1);
    const res3 = await step3(res2);
    console.log(res3);
  } catch (err) {
    console.error("Error occurred:", err);
  }
}
runSteps()