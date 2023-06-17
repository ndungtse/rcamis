window.addEventListener("DOMContentLoaded", () => {
    console.log("Hello World")
    const profBtn = document.querySelector("#profBtn")
    const proDropDiv = document.querySelector("#profDrop");
    profBtn?.addEventListener("click", (e) => {
        proDropDiv.classList.toggle("hidden")
    })
})