const header = document.getElementById("mainHeader");
const menuIcons = document.querySelectorAll("#container_icone_menu i");
let ultimaRolagem = 0;

document.querySelector(".fa-bars").style.display = "block";
document.querySelector(".fa-times").style.display = "none";

// Define o estado inicial para mobile
if (window.innerWidth <= 600) {
    header.classList.add("hide");
    document.querySelector(".fa-bars").style.display = "block";
    document.querySelector(".fa-times").style.display = "none";
}

// Alternar menu mobile
menuIcons.forEach(icon => {
    icon.addEventListener("click", () => {
        if (window.innerWidth <= 600) {
            header.classList.toggle("hide");
            header.classList.toggle("menu-open");
            
            // Alternar entre os ícones de menu e fechar
            document.querySelector(".fa-bars").style.display = 
                header.classList.contains("menu-open") ? "none" : "block";
            document.querySelector(".fa-times").style.display = 
                header.classList.contains("menu-open") ? "block" : "none";
        }
    });
});

// Comportamento de scroll para telas maiores
window.addEventListener("scroll", () => {
    if (window.innerWidth > 600) {
        const currentScroll = window.scrollY;

        if (currentScroll <= 0) {
            header.classList.remove("hide");
            return;
        }

        if (currentScroll > ultimaRolagem && !header.classList.contains("hide")) {
            header.classList.add("hide");
        } else if (currentScroll < ultimaRolagem && header.classList.contains("hide")) {
            header.classList.remove("hide");
        }

        ultimaRolagem = currentScroll;
    }
});

// Redimensionamento da janela
window.addEventListener("resize", () => {
    if (window.innerWidth > 600) {
        // Garante que o header fique visível ao mudar para desktop
        header.classList.remove("hide");
        header.classList.remove("menu-open");
        document.querySelector(".fa-bars").style.display = "block";
        document.querySelector(".fa-times").style.display = "none";
    } else {
        // Ao voltar para mobile, garante que o menu fique fechado
        if (!header.classList.contains("hide")) {
            header.classList.add("hide");
        }
        if (header.classList.contains("menu-open")) {
            header.classList.remove("menu-open");
        }
    }
});