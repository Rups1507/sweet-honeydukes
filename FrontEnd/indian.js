let mainbody = document.querySelector("#product-container");
let api = 'https://63c9170d320a0c4c9540575f.mockapi.io/products';
let searchform = document.querySelector("#form");
let clear1 = document.querySelector(".clear");
let nikefilter = document.querySelector("#nike");
let Adidasfilter = document.querySelector("#Adidas");
let Louisfilter = document.querySelector("#Louis");
let Cartierfilter = document.querySelector("#Cartier");
let Zarafilter = document.querySelector("#Zara");
let max = document.getElementById("max");
let min = document.getElementById("min");
let form = document.querySelector("#category-filter form");
let countspan = document.getElementById("countspan");

let viewcart = JSON.parse(localStorage.getItem("veiwproduct")) || [];
let addtocartarr = JSON.parse(localStorage.getItem("addtocart")) || [];

let arr = [];
let cart = [];
max.value = priceslider.value;

priceslider.oninput = function () {
  max.value = priceslider.value;
};

clear1.addEventListener("click", () => {
  max.value = 50;
  min.value = 0;
  priceslider.value = 50;
});

window.addEventListener("load", () => {
  mensdata();
});

countspan.innerHTML = addtocartarr.length;

async function mensdata() {
  try {
    let res = await fetch(api);
    let data = await res.json();

    form.addEventListener("submit", (e) => {
      e.preventDefault();
      let lower = +(min.value);
      let upper = +(max.value);
      let filtered = data.filter((element) => {
        if (element.price >= lower && element.price <= upper) {
          return true;
        } else {
          return false;
        }
      });
      renderingdata(filtered);
    });

    let filtered = data.filter((item) => {
      if (item.category == "bags") {
        arr.push(item);
      }
    });
    renderingdata(arr);

    form.addEventListener("submit", (e) => {
      e.preventDefault();
      let lower = +(min.value);
      let upper = +(max.value);
      let filtered = arr.filter((element) => {
        if (element.price >= lower && element.price <= upper) {
          return true;
        } else {
          return false;
        }
      });
      renderingdata(filtered);
    });

    nikefilter.addEventListener("click", () => {
      let filtered = arr.filter((ele) => {
        if (ele.brand == "nike") {
          return true;
        } else {
          return false;
        }
      });
      renderingdata(filtered);
    });

    Adidasfilter.addEventListener("click", () => {
      let filtered = arr.filter((ele) => {
        if (ele.brand == "adidas") {
          return true;
        } else {
          return false;
        }
      });
      renderingdata(filtered);
    });

    Louisfilter.addEventListener("click", () => {
      let filtered = arr.filter((ele) => {
        if (ele.brand == "louis vuitton") {
          return true;
        } else {
          return false;
        }
      });
      renderingdata(filtered);
    });

    Cartierfilter.addEventListener("click", () => {
      let filtered = arr.filter((ele) => {
        if (ele.brand == "cartier") {
          return true;
        } else {
          return false;
        }
      });
      renderingdata(filtered);
    });

    Zarafilter.addEventListener("click", () => {
      let filtered = arr.filter((ele) => {
        if (ele.brand == "zara") {
          return true;
        } else {
          return false;
        }
      });
      renderingdata(filtered);
    });

    searchform.addEventListener("submit", (e) => {
      e.preventDefault();
      let searchpara = searchform.search.value;
      let filtered1 = arr.filter((element) => {
        if (element.name.toUpperCase().includes(searchpara.toUpperCase()) === true) {
          return true;
        } else {
          return false;
        }
      });
      renderingdata(filtered1);
    });
  } catch (error) {
    console.log(error);
  }
}

function renderingdata(data) {
  mainbody.innerHTML = "";
  data.forEach((element, index) => {
    let div = document.createElement("div");
    div.classList.add("card");

    let div2 = document.createElement("div");
    div2.classList.add("img_div");
    div2.addEventListener("click", () => {
      viewcart = [element.id];
      localStorage.setItem("veiwproduct", JSON.stringify(viewcart));
      window.location.assign("product_vei.html");
    });

    let img = document.createElement("img");
    img.setAttribute("src", element.src);

    let div3 = document.createElement("div");
    div3.classList.add("desc");

    let Name = document.createElement("h2");
    Name.innerText = element.name;

    let Category = document.createElement("p");
    Category.innerText = element.category;

    let brand = document.createElement("p");
    brand.innerText = element.brand;

    let Price = document.createElement("p");
    Price.innerText = element.price;

    let product_badge = document.createElement("p");
    product_badge.innerText = element.product_badge;

    let buttondiv = document.createElement("div");
    buttondiv.classList.add("button-div");

    let addtocartbtn = document.createElement("button");
    addtocartbtn.innerHTML = "Add To Cart";

    addtocartbtn.addEventListener("click" ,()=>{
                    cart.push(element);
                    localStorage.setItem("addtocart",JSON.stringify(cart));
                    console.log(cart)
                  })

    let buytbtn = document.createElement("button");
    buytbtn.innerHTML = "Buy";

    buttondiv.append(addtocartbtn, buytbtn);
    div3.append(Name, Category, brand, Price, product_badge);
    div3.append(buttondiv);
    div2.append(img);
    div.append(div2, div3);
    mainbody.append(div);
  });
}
