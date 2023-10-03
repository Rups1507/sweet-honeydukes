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
  window.location="./admin.login.html";
});

let url = "https://63c9170d320a0c4c9540575f.mockapi.io/products";
let form = document.querySelector("#form");
let input = document.querySelectorAll("#form>input");
let product_name = document.querySelector("#name");
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

form.addEventListener("submit", (e) => {
  e.preventDefault();
  if (
    product_image.value !== "" &&
    product_name.value !== "" &&
    product_price.value !== "" &&
    product_quantity.value !== "" &&
    Category.value !== "" &&
    brand_name.value !== ""
  ) {
    let data = {
      src: product_image.value,
      name: product_name.value,
      price: product_price.value,
      category: Category.value,
      totalquantity: product_quantity.value,
      brand: brand_name.value,
    };

    sure.style.display = "block";
    yes.addEventListener("click", () => {
      AddInApi(data);
      setTimeout(() => {
        sure.style.display = "none";
        form.reset();
      }, 1000);
      setTimeout(() => {
        window.location="./all_Product.html";
      }, 2000);
    });

    nope.addEventListener("click", () => {
      setTimeout(() => {
        sure.style.display = "none";
        form.reset();
      }, 500);
    });
  } else {
    alert.style.display = "block";
    setTimeout(() => {
      alert.style.display = "none";
    }, 1000);
  }
});

async function AddInApi(details) {
  try {
    let res = await fetch(url, {
      method: "POST",
      headers: {
        "content-type": "application/json",
      },
      body: JSON.stringify(details),
    });
    let data = await res.json();
    console.log(data);
  } catch (error) {
    console.log(error.message);
  }
}
