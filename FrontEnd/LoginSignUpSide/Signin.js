var signupArr;
fetch('https://63ca391fd0ab64be2b4e8c76.mockapi.io/LoginCredientials').then((res)=>res.json()).then((a)=>{
signupArr = a;
console.log(signupArr);
})
function submit1() {
  let flag = true;
  event.preventDefault();
  var signupObj = {
    email: document.querySelector("#email").value,

    pass: document.querySelector("#pass").value,
  };
  signupArr.forEach((element)=>{
    if(element.email == signupObj.email){
      alert("Already Registered Email");
      window.location.href="Signin.html"
      flag = false;
    }
  })
  var pass2 = document.querySelector("#pass2").value;
  if (signupObj.pass == pass2 && signupObj.pass.length >= 8 && signupObj.pass !== "" && signupObj.email !== ""
  && flag) {
    signupArr.push(signupObj);
    console.log(signupArr);
  //  localStorage.setItem("signUpDetails", JSON.stringify(signupArr));

  // POSTING DATA IN DATABASE
    let obj = {
      email: signupObj.email,
      password:signupObj.pass,
      AddtoCart: [],
      favourites: [],
      OrderDetails: [],
     }
        
        fetch("https://63ca391fd0ab64be2b4e8c76.mockapi.io/LoginCredientials/",{  method: 'POST',
          headers: {
            'Content-type': 'application/json'
          },
          body: JSON.stringify(obj)
        }).then(()=>{
        window.location.href="Login.html";
        })   
    //window.location.href = "Login.html"

  }
  else {
    alert(" Please fill the details Carefully");
  }



}

// MY CODE