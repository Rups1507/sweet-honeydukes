let addressarr = JSON.parse(localStorage.getItem("addressdetail")) || []
let span = document.getElementById("span")
let name = document.getElementById("name")
let number = document.getElementById("number")
let month = document.getElementById("month")
let year = document.getElementById("year")
let cvv = document.getElementById("cvv")
let alert1 = document.querySelector(".alert")
let checkout = document.getElementById("checkout")

span.innerHTML = addressarr[0].name



let cardarr = JSON.parse(localStorage.getItem("carddetail"))



checkout.addEventListener("click",(e)=>{
    e.preventDefault()
    carddata()
})
function carddata(){
    let name1 = name.value
    let number1 = number.value
    let month1 = month.value
    let year1 = year.value
    let cvv1 = cvv.value

    console.log("yes")

    let formdata = [{
        name : name1,
        number : number1,
        month : month1,
        city : cvv1,
        year : year1,
        cvv : cvv1
    }]
    cardarr = formdata
    localStorage.setItem("carddetail",JSON.stringify(cardarr))
    alert1.style.display = "block"
    setTimeout(()=>{
        alert1.style.display = "none"
        window.location.assign("addressdetails.html")
    },1000)
    
}

