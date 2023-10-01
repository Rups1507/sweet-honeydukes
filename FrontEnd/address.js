let form = document.querySelector("#form")
let name1 = document.querySelector("#name")
let email1 = document.querySelector("#email")
let address1 = document.querySelector("#address")
let city1 = document.querySelector("#city")
let state1 = document.querySelector("#state")
let pincode1 = document.querySelector("#pincode")
let phone = document.querySelector("#phone")
let btn = document.getElementsByClassName("submit-btn")




let addressarr = JSON.parse(localStorage.getItem("addressdetail")) || []
console.log(addressarr)

form.addEventListener("submit",(e)=>{
    e.preventDefault()
    addressdata()
})
function addressdata(){
    let name = name1.value
    let email = email1.value
    let address = address1.value
    let city = city1.value
    let state = state1.value
    let pincode = pincode1.value


    if(name == ""){
        alert("fill name")
    }
    if(email == ""){
        alert("fill email")
    }
    if(address == ""){
        alert("fill address")
    }
    if(city == ""){
        alert("fill city")
    }
    if(state == ""){
        alert("fill state")
    }
    if(pincode == ""){
        alert("fill pincode")
    }

    let formdata = [{
        name : name,
        email : email,
        address : address,
        city : city,
        state : state,
        pincode : pincode
    }]
    addressarr = formdata
    localStorage.setItem("addressdetail",JSON.stringify(addressarr))
    window.location.assign("pay.html")
    
}