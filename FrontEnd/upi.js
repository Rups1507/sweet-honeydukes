let payable = document.getElementById("payable")
let addressarr = JSON.parse(localStorage.getItem("addressdetail")) || []
let amount = JSON.parse(localStorage.getItem("PayableAmount")) || []
let span = document.getElementById("span")
let upi = document.getElementById("upi")
let checkout = document.getElementById("checkout")
let alert1 = document.querySelector(".alert")
let form = document.querySelector("form")

span.innerHTML = addressarr[0].name
payable.innerHTML = amount
span.style.fontWeight = "bold"
span.style.textDecoration = "underline"
payable.style.fontWeight = "bold"
payable.style.textDecoration = "underline"

let cardarr = JSON.parse(localStorage.getItem("carddetail"))



form.addEventListener("submit",(e)=>{
    e.preventDefault()
    carddata()
})
function carddata(){




    let formdata = [{
        name : upi
    }]
    cardarr = formdata
    localStorage.setItem("carddetail",JSON.stringify(cardarr))
    alert1.style.display = "block"
    setTimeout(()=>{
        alert1.style.display = "none"
        window.location.assign("pay.html")
    },1000)
    
}
