var regdUsers;
 fetch('https://63ca391fd0ab64be2b4e8c76.mockapi.io/LoginCredientials').then((res)=>res.json()).then((a)=>{
  regdUsers = a;
  console.log(regdUsers);
 })


  function submit2() {
   // console.log(regdUsers)
    var mail = document.querySelector("#mail").value;
    var pass1 =document.querySelector("#pass1").value;
 
    if(mail == "admin@gmail.com" && pass1 == "admin123"){
        window.location.href = "admin.html";
        return;
    }
    var flag= false;
    for (var i = 0; i < regdUsers.length; i++) {
      if (regdUsers[i].email == mail && regdUsers[i].password == pass1) {
        flag=true;
     
        localStorage.setItem("id",regdUsers[i].id)
      } 
    }
    if(flag==true){
        alert("Login Successful");     
        window.location.href="index.html";
    }
    else{
        alert("Login Failed Please fill correct details");

    }
  }