document.addEventListener("click", function(e) {
    if (e.target.className=="button-up") {
     document.getElementsByClassName('registration-form-wrapper')[0].style.display = "block";
    // document.getElementsByClassName('car-image-wrapper')[0].style.display = "none";
    // document.getElementsByClassName('left-move')[0].style.display = "none";
    // document.getElementsByClassName('right-move')[0].style.display = "none";
     document.getElementsByClassName('swiper')[0].style.display = "none";
     document.getElementsByClassName('button-up')[0].style.display = "none";
    }
});

let swiper = new Swiper(".mySwiper", {
navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
    },
});