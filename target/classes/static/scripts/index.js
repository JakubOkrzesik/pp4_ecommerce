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
    return createHtmlFromString(template);
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

const getCurrentOffer = () => {
    return fetch("/api/offer")
        .then(response => response.json());
}

const refreshCurrentOffer = () => {
    console.log('i am going to refresh offer');
    const offerElement = document.querySelector('.cart');
    getCurrentOffer()
        .then(offer => {
            offerElement.querySelector('.total').textContent = `${offer.total} PLN`;
            offerElement.querySelector('.itemsCount').textContent = `${offer.itemsCount} items`;
        });
}

const addToCart = (productId) => {
    return fetch(`/api/add-to-cart/${productId}`)
}

const initializeAddToCartHandler = (el) => {
    const btn = el.querySelector('button.product__add-to-cart');
    btn.addEventListener('click', () => {
        addToCart(btn.getAttribute('data-product-id'))
            .then(refreshOffer())
    });
    return el;
}
(async () => {
    console.log("It works :)");
    const productsList = document.querySelector('#productsList');
    refreshCurrentOffer();
    const products = await getProducts();
    products
        .map(p => createProductComponent(p))
        .map(el => initializeAddToCartHandler(el))
        .forEach(el => productsList.appendChild(el));
    console.log("post get products");
})();