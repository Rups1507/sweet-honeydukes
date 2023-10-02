let body = document.getElementById("for-product");
let data =JSON.parse(localStorage.getItem("addtocart"))||[];
console.log(data);


let total =document.getElementById("total");


images =[
  "AssetsIndexPage/Bengali-sweets2.png",
  "AssetsIndexPage/dessert.jpg",
  "AssetsIndexPage/dessert2.jpg",
  "AssetsIndexPage/dessert.jpg",
  "AssetsIndexPage/cake.png",
  "AssetsIndexPage/rajsweet.png",
 
 
  "AssetsIndexPage/Bengali-sweets2.png",
  "AssetsIndexPage/dessert.jpg",
  "AssetsIndexPage/dessert2.jpg",
  "AssetsIndexPage/dessert.jpg",
  "AssetsIndexPage/cake.png",
  "AssetsIndexPage/rajsweet.png",
 
 
  "AssetsIndexPage/Bengali-sweets2.png",
  "AssetsIndexPage/dessert.jpg",
  "AssetsIndexPage/dessert2.jpg",
  "AssetsIndexPage/dessert.jpg",
  "AssetsIndexPage/cake.png",
  "AssetsIndexPage/rajsweet.png"
 
 
   ]




display(data)
function display(data){
  body.innerHTML ="";

 
  data.forEach((ele,ind)=> {
   
      
    
   

   
    let sum=0;
      let card =document.createElement("div");
    let image =document.createElement("img");
    let name =document.createElement("h3");
    let price =document.createElement("h4");
    let button =document.createElement("button");
    button.innerText="delete";
    button.addEventListener("click",()=>{
     let ele= data.splice(ind,1);
     localStorage.setItem("addtocart",JSON.stringify(data));
     display(data)
    })
    
       sum=sum+Number(ele.price)




       image.src=images[0];
    name.textContent=ele.name;
    price.textContent="₹"+ele.price;
    card.append(image,name,price,button);
    


    body.append(card);
    console.log(ele)

   
   
    

 
  });

  let sum=0;
  for(let i=0; i<data.length; i++){
                    sum =sum+data[i].price;
  }
  total.textContent =sum;
 
}












// document.querySelector("#P").addEventListener("click",function(){
// window.location.href = "payment.html"
// })





// let url = "https://63c9170d320a0c4c9540575f.mockapi.io/products";
// let appending_div = document.querySelector("#for-product"); // in this div , every product will append
// let amount_show = document.querySelector("#totalAppend");
// let total_amount_show = document.querySelector("#total-Amount-Append");
let checkoutBtn = document.querySelector("#Checkout");
let positive_amount;
let alerts = document.querySelector(".alert");
let radioBtn = document.getElementsByName("order");
let api_data = [];

// let addtocart_data = JSON.parse(localStorage.getItem("addtocart"));
// if (addtocart_data == null) {
//   addtocart_data = [];
// }

// // api data coming here
// window.addEventListener("load", () => {
//   fetch(url)
//     .then((res) => {
//       return res.json();
//     })
//     .then((data) => {
//       api_data = data;
//       excute_func(api_data,addtocart_data);
//     });
// });
// let arr = []
// // this is the funtion responsible for excuting
// function excute_func(apiData, cartData) {
//   let totalAmount = 0;
//   // geting unique data
//   let uniqueElement = new Set(cartData);

//   let data = apiData.filter((element) => {
//     let flag = false;
//     uniqueElement.forEach((ele) => {
//       if (element.id == ele) {
//         flag = true;
//       }
//     });
//     return flag;
//   }); // filter data;

//   appending_div.innerHTML = "";

// let obj = {}


//   data.forEach((ele) => {
//     // creating here
//     let number = 1;
//     let main = document.createElement("div");
//     let div1 = document.createElement("div");
//     let div2 = document.createElement("div");
//     let crossIcon = document.createElement("div");

//     let image = document.createElement("img");

//     let productName = document.createElement("p");
//     let refCode = document.createElement("p");
//     let tickDiv = document.createElement("div");
//     let first = document.createElement("div");
//     let second = document.createElement("div");
//     let quantityDiv = document.createElement("div");
//     let quantityTag = document.createElement("p");
//     let incrementDiv = document.createElement("div");
//     let decrementBtn = document.createElement("button");
//     let displayNumber = document.createElement("p");
//     let IncrementBtn = document.createElement("button");
//     let price = document.createElement("p");

//     // filling id here
//     main.id = "under-main";
//     div1.id = "child1";
//     div2.id = "child2";
//     crossIcon.id = "remove";
//     productName.id = "pr-name";
//     tickDiv.id = "tickDiv";
//     quantityDiv.id = "quantityDiv";
//     incrementDiv.id = "incrementDiv";
//     displayNumber.id = "displayNumber";
//     price.id = "priceOF";

//     // setting data here
//     image.setAttribute("src", ele.src);
//     productName.textContent = ele.name;
//     refCode.textContent = ele.badge ?? "New";
//     first.innerHTML = `<i class="fa-solid fa-check"></i> <span>Home Delivary</span>`;
//     second.innerHTML = `<i class="fa-solid fa-check"></i> <span>Replacement in 7 Day </span>`;
//     quantityTag.textContent = "Qty:";
//     decrementBtn.innerHTML = `<i class="fa-solid fa-minus"></i>`;
//     displayNumber.textContent = number;
//     IncrementBtn.innerHTML = `<i class="fa-solid fa-plus"></i>`;
//     price.textContent = ele.price;

//     crossIcon.innerHTML = `<i class="fa-sharp fa-solid fa-trash"></i>`;

//     // some functionality over element
//     crossIcon.addEventListener("click", () => {  

//      uniqueElement.forEach((idd)=>{
//      if (idd==ele.id) {
//       uniqueElement.delete(idd);
//      }
//      })
//       addtocart_data = [...uniqueElement];
//       localStorage.setItem("addtocart", JSON.stringify(addtocart_data));
//       excute_func(apiData, addtocart_data)
   
//       alerts.innerHTML = "Item Deleted";
//       alerts.style.display = "block";
//       setTimeout(() => {
//         alerts.style.display = "none";
//       }, 500);


//     });

//     let arr1 = []
//     decrementBtn.addEventListener("click", () => {
      
//       number--;
//       if (number > 0 ) {
//         totalAmount -= Number(ele.price);
//       }
//       if (number === 0) number = 1;

//       displayNumber.textContent = number;
//       positive_amount = totalAmount; // store outside for verify
//       amount_show.innerHTML = totalAmount;
//       total_amount_show.innerHTML = totalAmount;
//       obj[ele.name] = number
//       // console.log(obj)
//       arr1 = obj
//       console.log(arr1)
//       arr.push(arr1)
//       localStorage.setItem("productname",JSON.stringify(arr))
//     });

//     IncrementBtn.addEventListener("click", () => {
      
//       number++;
//       displayNumber.textContent = number;
//       totalAmount += Number(ele.price);
//       positive_amount = totalAmount; // store outside for verify
//       amount_show.innerHTML = totalAmount;
//       total_amount_show.innerHTML = totalAmount;
//       obj[ele.name] = number
//       // console.log(obj)
//       arr.push(obj)
//       arr1 = obj
//       console.log(arr1)
//       arr.push(arr1)
//       localStorage.setItem("productname",JSON.stringify(arr))
//     });
//     // some functionality over element

//     // appending here
//     incrementDiv.append(decrementBtn, displayNumber, IncrementBtn);
//     quantityDiv.append(quantityTag, incrementDiv, price);
//     tickDiv.append(first, second);
//     div2.append(productName, refCode, tickDiv, quantityDiv);
//     div1.append(image);
//     main.append(div1, div2, crossIcon);
//     appending_div.append(main);

//     totalAmount += Number(ele.price);
//     positive_amount = totalAmount;
//   });

//   // update amount to DOM
//   amount_show.innerHTML = totalAmount;
//   total_amount_show.innerHTML = totalAmount;
// }

// //checkout button here


// button.addEventListener("click",()=>{
//   let ele= data.splice(ind,1);
//   localStorage.setItem("addtocart",JSON.stringify(data));
//   display(data)
//  })
// let radio_flag = false;

//  for (let index = 0; index < radioBtn.length; index++) {
//   radioBtn[index].addEventListener("click", () => {
//     radio_flag = true;
//   });
// }
checkoutBtn.addEventListener("click", () =>{
  // if (positive_amount > 0 && radio_flag == true) {
    // localStorage.setItem("PayableAmount", positive_amount);
    window.location.assign("paymentpage.html");
  
  // }
  // if (radio_flag == false) {
  //   alerts.innerHTML = "Select option Please !";
  //   alerts.style.display = "block";
  //   setTimeout(() => {
  //     alerts.style.display = "none";
  //   }, 500);
  // } else {
  //   alerts.innerHTML = "Your Cart is Empty";
  //   alerts.style.display = "block";
  //   setTimeout(() => {
  //     alerts.style.display = "none";
  //   },500);
// }
});