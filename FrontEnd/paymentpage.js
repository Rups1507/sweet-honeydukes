let payable = document.getElementById("payable")
let addressarr = JSON.parse(localStorage.getItem("addressdetail")) || []


let upi = document.getElementById("upi")
let checkout = document.getElementById("checkout")
let alert1 = document.querySelector(".alert")
let COD = document.querySelector(".COD")




let cardarr = JSON.parse(localStorage.getItem("carddetail"))



COD.addEventListener("click",(e)=>{
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
        window.location.assign("index.html")
    },1000)
    
}
