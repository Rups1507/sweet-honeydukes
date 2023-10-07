const body = document.querySelector("body"),
  sidebar = body.querySelector("nav");
sidebarToggle = body.querySelector(".sidebar-toggle");

sidebarToggle.addEventListener("click", () => {
  sidebar.classList.toggle("close");
  if (sidebar.classList.contains("close")) {
    localStorage.setItem("status", "close");
  } else {
    localStorage.setItem("status", "open");
  }
});

let admin_check = localStorage.getItem("check");
let admin_name = localStorage.getItem("admin");
let alert = document.querySelector(".alert");

window.addEventListener("load", () => {
  if (admin_check == null) {
    window.location="./Admin.registration.html";
  }
  if (admin_name !== null) {
    alert.innerText = `Welcome ${admin_name} !`;
    alert.style.display = "block";
    setTimeout(() => {
      alert.style.display = "none";
    }, 1000);
  }
  getdata();
});

let logout = document.querySelector(".logout-mode");
logout.addEventListener("click", () => {
  localStorage.removeItem("check");
  window.location.href = '/index.html';

});

function getdata() {
  let url = "https://63c9170d320a0c4c9540575f.mockapi.io/products";
  fetch(url)
    .then((res) => {
      return res.json();
    })
    .then((data) => {
      excution(data);
    });
}

function excution(arr) {
  // to get total product
  let total_product = document.querySelector("#product-num");
  let total = 0;
  arr.forEach((element) => {
    total += Number(element.totalquantity);
  });
  total_product.innerHTML = total;
}

// click over box
let box1 = document.querySelector(".box1");

box1.addEventListener("click", () => {
    window.location='./all_Product.html';;
});




//
let tbody=document.querySelector("#tbody");
let ls_data=JSON.parse(localStorage.getItem('recent'));
if (ls_data==null) {
  ls_data=[];
}
appending(ls_data);

function appending(data) {
  data.forEach((element) => {
    let product_tr = document.createElement("tr");
    // let user_name = document.createElement("td");
    let all_product = document.createElement("td");
    let total_amount = document.createElement("td");
    let E_kert = document.createElement("td");

    // user_name.textContent = user_names;
    all_product.textContent = element.name;
    total_amount.textContent = element.price;
    E_kert.textContent = "Handover Done...";
    E_kert.className = "Kert";
    E_kert.addEventListener("click", () => {
      sure.style.display = "block";
      yes.addEventListener("click", () => {
        recent_data.push(element);
        localStorage.setItem('recent',JSON.stringify(recent_data))
        sure.style.display = "none";
        window.location = "./admin.html";
      });
      nope.addEventListener("click", () => {
        sure.style.display = "none";
      });
    });

    product_tr.append(all_product, total_amount, E_kert);
    tbody.append(product_tr);
  });
}