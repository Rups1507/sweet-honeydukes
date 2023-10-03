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
// let alert = document.querySelector(".alert");
let tbody = document.querySelector("tbody");
let url = "https://63c9170d320a0c4c9540575f.mockapi.io/products";
let global_data = []; //store data from api
let sure = document.querySelector("#sure");
let yes = document.querySelector("#yes");
let nope = document.querySelector("#no");



let user_names =localStorage.getItem("userdata");;
let item = JSON.parse(localStorage.getItem("addtocart"));
let total_amounts = localStorage.getItem("payble_Amount");
if (item == null) {
  item = [];
}

let recent_data=JSON.parse(localStorage.getItem('recent'));
if (recent_data==null) {
  recent_data=[];
}


window.addEventListener("load", () => {
  if (admin_check == null) {
    window.location = "./Admin.registration.html";
  }
  // if (admin_name !== null) {
  //   alert.innerText = `Welcome ${admin_name} !`;
  //   alert.style.display = "block";
  //   setTimeout(() => {
  //     alert.style.display = "none";
  //   }, 1000);
  // }
  api_coll(); // here i am calling the function
});

let logout = document.querySelector(".logout-mode");
logout.addEventListener("click", () => {
  localStorage.removeItem("check");
  window.location = "./admin.login.html";
});

// fetch the data

async function api_coll() {
  try {
    let res = await fetch(url);
    let fetch_data = await res.json();
    appending(fetch_data, item);
  } catch (error) {
    console.log(error.message);
  }
}

function appending(fetched_data, items) {
  let uniqueElement = new Set(items);
  tbody.innerText = "";
  let data = fetched_data.filter((element) => {
    let flag = false;
    uniqueElement.forEach((ele) => {
      if (element.id == ele) {
        flag = true;
      }
    });
    return flag;
  }); // filter data;

  data.forEach((element) => {
    let product_tr = document.createElement("tr");
    // let user_name = document.createElement("td");
    let all_product = document.createElement("td");
    let total_amount = document.createElement("td");
    let E_kert = document.createElement("td");

    // user_name.textContent = user_names;
    all_product.textContent = element.name;
    total_amount.textContent = element.price;
    E_kert.textContent = "Handover to logistic";
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

// // filter here
// let filter = document.querySelector("#filter");
// filter.addEventListener("change", () => {
//   if (filter.value == "") {
//     setTimeout(() => {
//       appending(global_data);
//     }, 200);
//   } else {
//     let filtered = global_data.filter((ele) => {
//       return ele.category == filter.value;
//     });
//     setTimeout(() => {
//       appending(filtered);
//     }, 200);
//   }
// });

// // searching
// let search = document.querySelector("#search");
// let searchbtn = document.querySelector(".uil-search");
// searchbtn.addEventListener("click", () => {
//   let searchValue = search.value.toLowerCase();
//   if (search !== "") {
//     let filtered = global_data.filter((ele) => {
//       let names = ele.name.toLowerCase();
//       return names.includes(searchValue);
//     });
//     appending(filtered);
//   }
// });
