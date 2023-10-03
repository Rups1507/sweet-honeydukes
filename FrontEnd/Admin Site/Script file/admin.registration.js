const form = document.querySelector("form");
let eField = form.querySelector(".email");
let eInput = eField.querySelector("input");
let pField = form.querySelector(".password");
let pInput = pField.querySelector("input");

form.onsubmit = (e) => {
  e.preventDefault(); //preventing from form submitting
  //if email and password is blank then add shake class in it else call specified function
  eInput.value == "" ? eField.classList.add("shake", "error") : checkEmail();
  pInput.value == "" ? pField.classList.add("shake", "error") : checkPass();

  setTimeout(() => {
    //remove shake class after 500ms
    eField.classList.remove("shake");
    pField.classList.remove("shake");
  }, 500);

  eInput.onkeyup = () => {
    checkEmail();
  }; //calling checkEmail function on email input keyup
  pInput.onkeyup = () => {
    checkPass();
  }; //calling checkPassword function on pass input keyup

  function checkEmail() {
    //checkEmail function
    let pattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/; //pattern for validate email
    if (!eInput.value.match(pattern)) {
      //if pattern not matched then add error and remove valid class
      eField.classList.add("error");
      eField.classList.remove("valid");
      let errorTxt = eField.querySelector(".error-txt");
      //if email value is not empty then show please enter valid email else show Email can't be blank
      eInput.value != ""
        ? (errorTxt.innerText = "Enter a valid email address")
        : (errorTxt.innerText = "Email can't be blank");
    } else {
      //if pattern matched then remove error and add valid class
      eField.classList.remove("error");
      eField.classList.add("valid");
    }
  }

  function checkPass() {
    //checkPass function
    if (pInput.value == "") {
      //if pass is empty then add error and remove valid class
      pField.classList.add("error");
      pField.classList.remove("valid");
    } else {
      //if pass is empty then remove error and add valid class
      pField.classList.remove("error");
      pField.classList.add("valid");
    }
  }

  //if eField and pField doesn't contains error class that mean user filled details properly
  if (
    !eField.classList.contains("error") &&
    !pField.classList.contains("error")
  ) {
    window.location.href = form.getAttribute("action"); //redirecting user to the specified url which is inside action attribute of form tag
  }
};

let passcode_div = document.querySelector("#passcode"); //for varify if admin or not
let new_form = document.querySelector(".wrapper"); //entire registration form
let names = document.querySelector("#admin-name");
let email = document.getElementById("admin-email");
let password = document.getElementById("admin-password");
let url = "https://6410847f7b24bb91f21fd94b.mockapi.io/ali"; //api for post http method
let code = "admin"; //passcode
let taking_code = document.querySelector("#code"); //passcode input
let taking_code_form = document.querySelector("#passcode form");
let alert = document.querySelector(".alert"); //if passcode is wrong

let registration_check = localStorage.getItem("registration"); // check if already registration done or not

window.addEventListener("load", () => {
  new_form.style.display = "none";
  passcode_div.style.display = "block";
  if (registration_check !== null) {
  window.location='./admin.login.html'
  }
});

taking_code_form.addEventListener("submit", (e) => {
  // passcode div
  e.preventDefault();

  if (code == taking_code.value) {
    passcode_div.style.display = "none";
    new_form.style.display = "block";
  } else {
    alert.style.display = "block";
    setTimeout(() => {
      alert.style.display = "none";
    }, 1000);
  }
  taking_code_form.reset();
});

form.addEventListener("submit", (e) => {
e.preventDefault();
  // registration via post method
  if (names.value !== "" && email.value !== "" && password.value !== "") {
    let data = {
      name: names.value,
      email: email.value,
      password: password.value,
    };
    registration(data);
   
    
  }
});

async function registration(details) {
  try {
    let res = await fetch(url, {
      method: "POST",
      headers: {
        "content-type": "application/json",
      },
      body: JSON.stringify(details),
    });
    let data = await res.json();
    localStorage.setItem("registration", true);
    window.location="./admin.login.html"
  } catch (error) {
    console.log(error);
  }
}
