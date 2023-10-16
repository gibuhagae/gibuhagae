// if (document.readyState === 'loading') {
//     document.addEventListener('DOMContentLoaded', ready)
// } else {
//     ready();
// }
//
// function ready() {
//     const removeCartItemButtons = document.getElementsByClassName('remove-btn');
//
//     for (let i = 0; i < removeCartItemButtons.length; i++) {
//         let button = removeCartItemButtons[i];
//         button.addEventListener('click', removeCartItem)
//     }
//
//     let quantityInputs = document.getElementsByClassName('cart-quantity-input');
//     for (let i = 0; i < quantityInputs.length; i++) {
//         let input = quantityInputs[i];
//         input.addEventListener('change', quantityChanged)
//     }
//
//     // 버튼 수량 변경
//     let plusButtons = document.getElementsByClassName('plus-btn');
//     for (let i = 0; i < plusButtons.length; i++) {
//         let plusBtn = plusButtons[i];
//         plusBtn.addEventListener('click', plusClicked)
//     }
//
//     let minusButtons = document.getElementsByClassName('minus-btn');
//     for (let i = 0; i < minusButtons.length; i++) {
//         let minusBtn = minusButtons[i];
//         minusBtn.addEventListener('click', minusClicked)
//     }
//
//     let addToCartButtons = document.getElementsByClassName('tocart');
//     for (let i = 0; i < addToCartButtons.length; i++) {
//         let button = addToCartButtons[i];
//         button.addEventListener('click', addToCartClicked);
//     }
//
//     initializeCheckbox();
//
//     handleCheckboxEvents();
//
//     updatePrice();
//
//     let clearCartButton = document.getElementById('clear-button');
//     clearCartButton.addEventListener('click', cartclearClicked);
//
//     document.getElementsByClassName('purchase-btn')[0].addEventListener('click', purchaseClicked);
//
// }
//
// function purchaseClicked() {
//
//     let cartItems = document.getElementsByClassName('cart-items')[0];
//     let itemCheckboxes = document.getElementsByClassName('item-checkbox');
//     for (let i = 0; i < itemCheckboxes.length; i++) {
//         if (itemCheckboxes[i].checked) {
//             cartItems.removeChild(cartItems.children[i]);
//             i--;
//         }
//     }
//     updateCartTotal();
// }
//
// function handleCheckboxEvents() {
//     let seletAll = document.getElementById('select-all');
//     let eachBox  = document.getElementsByClassName('item-checkbox');
//
//     seletAll.addEventListener('click', () => {
//
//         for (let i = 0; i < eachBox.length; i++) {
//             eachBox[i].checked = seletAll.checked;
//         }
//         updateCartTotal();
//     });
//
//     for (let i = 0; i < eachBox.length; i++) {
//         eachBox[i].addEventListener('click', () => {
//
//             count = 0;
//
//             for (let i = 0; i < eachBox.length; i++) {
//                 if (eachBox[i].checked == true) {
//                     count++;
//                 }
//             }
//
//             if (eachBox.length == count) {
//                 seletAll.checked = true;
//             } else {
//                 seletAll.checked = false;
//             }
//             updateCartTotal();
//         });
//     }
// }
//
// function initializeCheckbox() {
//     let seletAll = document.getElementById('select-all');
//     let eachBox  = document.getElementsByClassName('item-checkbox');
//     seletAll.checked = true;
//     for (let i = 0; i < eachBox.length; i++) {
//
//         eachBox[i].checked = true;
//     }
// }
//
// // function updatePrice() {
// //
// //     let quantityInputs = document.getElementsByClassName('cart-quantity-input');
// //     let cartPrices = document.getElementsByClassName('cart-price');
// //
// //     for (let i = 0; i < quantityInputs.length; i++) {
// //
// //         let quantityInput = quantityInputs[i];
// //         let cartPrice = cartPrices[i];
// //         let price = parseFloat(cartPrice.innerText.replace(',', ''));
// //         let quantity = quantityInput.value;
// //
// //         let newPrice = price * quantity;
// //
// //         cartPrice.innerText = newPrice;
// //     }
// //
// //     updateCartTotal();
// // }
//
// function cartclearClicked (event) {
//     let cartRows = document.getElementsByClassName('cart-items')[0];
//
//     while (cartRows.firstChild) {
//         cartRows.removeChild(cartRows.firstChild);
//     }
//
//     updateCartTotal();
// }
//
// function removeCartItem(event) {
//     let buttonClicked = event.target;
//     buttonClicked.parentElement.parentElement.parentElement.remove();
//     updateCartTotal();
// }
//
// function quantityChanged(event) {
//     let input = event.target;
//
//     if (isNaN(input.value) || input.value <= 0) {
//         input.value = 1;
//     }
//
//     updateCartTotal();
// }
//
// function plusClicked() {
//
//     let basketNo = document.getElementById('basketNo').value;
//     console.log(basketNo);
//     fetch(`/quantity/plus?basketNo=${basketNo}`, {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json; charset=UTF-8'
//         },
//         body: JSON.stringify({ "basketNo": basketNo })
//     })
//         .then(result => result.text())
//         .then(result => {
//             alert(result);
//             updatePrice();
//             location.href="/basket";
//         })
//         .catch(error => {
//             console.error('서버 요청 중 오류가 발생했습니다.', error);
//         });
// }
//
// function minusClicked(event) {
//     let minusButton = event.target;
//     let quantityInput = minusButton.closest('.cart-detail').querySelector('.cart-quantity-input');
//     let currentValue = parseInt(quantityInput.value);
//     if (currentValue > 1) {
//         quantityInput.value = currentValue - 1;
//         updateCartTotal();
//     }
// }

// function updateCartTotal() {
//     let cartItemContainer = document.getElementsByClassName('cart-items')[0];
//     let cartRows = cartItemContainer.getElementsByClassName('cart-detail');
//
//         let total = 0;
//
//         for (let i = 0; i < cartRows.length; i++) {
//             let cartRow = cartRows[i];
//
//             let checkbox = cartRow.getElementsByClassName('item-checkbox')[0];
//             if (checkbox.checked == true) {
//                 let priceElement = cartRow.getElementsByClassName('cart-price')[0];
//                 let quantityElement = cartRow.getElementsByClassName('cart-quantity-input')[0];
//                 let price = parseFloat(priceElement.innerText.replace(',', ''));
//                 let quantity = quantityElement.value;
//
//                 total += price * quantity;
//             }
//         }
//
//         total = Math.round(total * 100) / 100;
//         let originTotal = total.toLocaleString();
//
//         document.getElementsByClassName('cart-item-price')[0].innerText = originTotal;
//         document.getElementById('cart-item-price').innerText = originTotal;
//         document.getElementsByClassName('cart-total-price')[0].innerText = originTotal;
//         document.getElementById('cart-total-price').innerText = originTotal;
//
// }