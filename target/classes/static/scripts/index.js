const a=5
const foo = ()=> {console.log("hello world")};
document.addEventListener("DOMContentLoaded",()=>{
    foo();
})

const getProducts = () => {
    return fetch("/api/products")
        .then(response => response.json());
}

const createHtmlComponent = (product) => {
    const template = `
        <li class="product">
            <h4>${product.name}</h4>
            <img />
            <span>${product.price}</span>
            <button 
                class="product__add-to-cart"
                data-product-id="${product.id}">
                Add to cart +
            </button>
        </li>
    `;
}

const createHtmlFromString = (htmlAsString) => {
    const tmpElem = document.createElement('div');
    tmpElem.innerHTML = htmlAsString
    return tmpElem.firstChild;
}

(() => {
    const productsListElement = document.querySelector('#products-list')
    getProducts()
        .then(products => {
            products
                .map(product => createHtmlComponent(product))
                .forEach(el => productsListElement.appendChild(el))
        });
})()