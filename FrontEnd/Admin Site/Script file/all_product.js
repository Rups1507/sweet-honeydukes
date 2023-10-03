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

window.addEventListener("load", () => {
  if (admin_check == null) {
    window.location="./Admin.registration.html";
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
  window.location="./admin.login.html";
});

// fetch the data

async function api_coll() {
  try {
    let res = await fetch(url);
    let data = await res.json();
    global_data = data;
    appending(data);
  } catch (error) {
    console.log(error.message);
  }
}

function appending(data) {
  tbody.innerText = "";
  data.forEach((element) => {
    let product_tr = document.createElement("tr");
    let image = document.createElement("td");
    let img = document.createElement("img");
    let product_name = document.createElement("td");
    let product_category = document.createElement("td");
    let div1 = document.createElement("td");
    let product_quantity = document.createElement("p");
    let product_remove = document.createElement("td");

    img.setAttribute("src", element.src);
    product_name.textContent = element.name;
    product_category.textContent = element.category;
    product_quantity = textContent = element.totalquantity;
    product_remove.textContent = "Delete";

    product_remove.addEventListener("click", () => {
      sure.style.display = "block";
      yes.addEventListener("click", () => {
        remove(element);
        setTimeout(() => {
          sure.style.display = "none";
        }, 1000);
      });

      nope.addEventListener("click", () => {
        setTimeout(() => {
          sure.style.display = "none";
        }, 500);
      });
    }); // for removing the item

    div1.id = "quantity";
    product_remove.id = "remove";
    div1.append(product_quantity);
    image.append(img);
    product_tr.append(
      image,
      product_name,
      product_category,
      div1,
      product_remove
    );
    tbody.append(product_tr);
  });
}

function remove(ele) {
  fetch(`${url}/${ele.id}`, {
    method: "DELETE",
  });
  api_coll();
}

// filter here
let filter = document.querySelector("#filter");
filter.addEventListener("change", () => {
  if (filter.value == "") {
    setTimeout(() => {
      appending(global_data);
    }, 200);
  } else {
    let filtered = global_data.filter((ele) => {
      return ele.category == filter.value;
    });
    setTimeout(() => {
      appending(filtered);
    }, 200);
  }
});

// searching
let search = document.querySelector("#search");
let searchbtn = document.querySelector(".uil-search");
searchbtn.addEventListener("click", () => {
  let searchValue=search.value. toLowerCase();
  if (search !== "") {
    let filtered = global_data.filter((ele) => {
      let names=ele.name.toLowerCase();
      return names.includes(searchValue);
    });
    appending(filtered);
  }
});
