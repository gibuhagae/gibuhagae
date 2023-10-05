



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