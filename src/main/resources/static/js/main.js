/* main banner 슬라이드 script */

let slideIndex = 0;
showSlides();

function showSlides() {
    let i;
    let slides = document.getElementsByClassName("mySlides");
    let dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 4000); // Change image every 4 seconds
}



/* main best 상품 슬라이드 script */
const sliderWrapper = document.querySelector('.slider-wrapper');
let currentIndex = 0;
const slideWidth = 100; // 1 슬라이드의 너비 (%)

function prevSlide() {
    if (currentIndex > 0) {
        currentIndex--;
        updateSliderPosition();
    }
}
function nextSlide() {
    const maxIndex = Math.floor((sliderWrapper.children.length - 1) / 3);
    if (currentIndex < maxIndex) {
        currentIndex++;
        updateSliderPosition();
    }
}
function updateSliderPosition() {
    sliderWrapper.style.transform = `translateX(-${currentIndex * slideWidth}%)`;
}