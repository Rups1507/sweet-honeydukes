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

let logout = document.querySelector(".logout-mode");
logout.addEventListener("click", () => {
  localStorage.removeItem("check");
  window.location="/admin.login.html";
}); // logout button

let product_update_div = document.querySelector("#product-update");

let url = "https://63c9170d320a0c4c9540575f.mockapi.io/products";
let form = document.querySelector("#form");
let input = document.querySelectorAll("#form>input");
let product_name = document.querySelector("#names");
let product_price = document.querySelector("#price");
let Category = document.querySelector("#category");
let product_quantity = document.querySelector("#quantity");
let brand_name = document.querySelector("#brand");
let product_image = document.querySelector("#image");
let sure = document.querySelector("#sure");
let yes = document.querySelector("#yes");
let nope = document.querySelector("#no");
let alert = document.querySelector(".alert");

input.forEach((ele) => {
  ele.addEventListener("mouseover", () => {
    ele.style.outline = "none";
  });
});

async function AddInApi(Data_To_Update, Product_id) {
  try {
    let res = await fetch(`${url}/${Product_id}`, {
      method: "PUT",
      headers: {
        "content-type": "application/json",
      },
      body: JSON.stringify(Data_To_Update),
    });
    let data = await res.json();
    console.log(data);
  } catch (error) {
    console.log(error.message);
  }
}
let product_image_showing = document.querySelector("#product-image-showing");
let image_append_here = document.querySelector("#image-append-here");

let sure2 = document.querySelector("#sure2");
let yes2 = document.querySelector("#yes2");
let nope2 = document.querySelector("#no2");
let product_names_show = document.querySelector("#product-names");
let ask_category = document.querySelector("#ask-category");
let product_category = document.querySelector("#product_category");
let all_product_data = []; // all api data

window.addEventListener("load", () => {
  sure2.style.display = "block";
  yes2.addEventListener("click", () => {
    setTimeout(() => {
      sure2.style.display = "none";
      ask_category.style.display = "block";
    }, 500);
  });
  nope2.addEventListener("click", () => {
    setTimeout(() => {
      sure2.style.display = "none";
    }, 500);
  });
  api_Data_Get();
});

async function api_Data_Get() {
  let res = await fetch(url);
  let data = await res.json();
  name_show(data);
  all_product_data = data;
}

function name_show(details) {
  product_names_show.innerHTML = "";
  details.forEach((ele) => {
    let name_list = document.createElement("p");
    name_list.textContent = ele.name;
    name_list.addEventListener("click", () => {
      if (product_category.value !== "") {
        data_update(ele.name); // here i am colling form function
        ImageShow(ele.src);
      } else {
        alert.innerHTML = "Select Category!";
        alert.style.display = "block";
        setTimeout(() => {
          alert.style.display = "none";
        }, 1000);
      }
    });
    product_names_show.append(name_list);
  });
}

// update the product here
function data_update(product_name) {
  ask_category.style.display = "none";
  product_update_div.style.display = "block";

  let filtered = all_product_data.filter((ele) => {
    return ele.name == product_name && ele.category == product_category.value;
  });
  let product_id = filtered.id;
  let updated_data;

  console.log(filtered);

  form.addEventListener("submit", (e) => {
    e.preventDefault();

    let data = {
      src: product_image.value,
      name: product_name.value,
      price: product_price.value,
      category: Category.value,
      totalquantity: product_quantity.value,
      brand: brand_name.value,
    };
    updated_data = data;

    sure.style.display = "block";
    yes.addEventListener("click", () => {
      AddInApi(updated_data, product_id); //here colling api
      setTimeout(() => {
        sure.style.display = "none";
        form.reset();
      }, 1000);
    });
    setTimeout(() => {
      window.location="./all_Product.html";
    }, 2000);

    nope.addEventListener("click", () => {
      setTimeout(() => {
        sure.style.display = "none";
        form.reset();
      }, 500);
    });
  });
}

// image show here
function ImageShow(imageData) {
  setTimeout(() => {
    image_append_here.textContent = "";
    let image = document.createElement("img");
    image.setAttribute("src", imageData);
    image_append_here.append(image);

    product_image_showing.style.display = "block";
  }, 1000);
}
