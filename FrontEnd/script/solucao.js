const mensagem_texto_01 = document.getElementsByClassName("mensagem_texto_01")[0]
const mensagem_texto_02 = document.getElementsByClassName("mensagem_texto_02")[0]

// Elementos para exibir cidade e temperatura
const city = document.getElementsByClassName('city')[0]
const temp_numb = document.getElementsByClassName('temp_numb')[0]

const API_KEY = "e01fb5f8a247e7ee3ea32a2a563b2791";
const CITY_NAME = "São Paulo";

// Carrega dados do tempo e relógio quando a página abre
window.onload = async function fetchWeather() {
     try {
         // Busca dados meteorológicos da API
         const response = await fetch(
             `https://api.openweathermap.org/data/2.5/weather?q=${CITY_NAME}&appid=${API_KEY}&units=metric`
         );
         const data = await response.json();
         
         if (data.cod === 200) { 
             // Atualiza cidade e temperatura na tela
             city.innerHTML=`${CITY_NAME}`;
             temp_numb.innerHTML=`${data.main.temp}`;

         // Mostra mensagem diferente conforme a temperatura
         if(data.main.temp >= 30){
             mensagem_texto_01.style.display = "none"
             mensagem_texto_02.style.display = "flex"
         }else{
             mensagem_texto_02.style.display = "flex"
             mensagem_texto_01.style.display = "none"
         }
         
         } else {
             console.error("Error:", data.message);
         }
     } catch (error) {
         console.error("Failed to fetch weather:", error);
     }

    // Função para relógio digital
    function atualizarRelogio() {
       const agora = new Date();
       const horas = agora.getHours().toString().padStart(2, '0');
       const minutos = agora.getMinutes().toString().padStart(2, '0');
       const segundos = agora.getSeconds().toString().padStart(2, '0');
    
       document.getElementById('relogio').textContent = `${horas}:${minutos}:${segundos}`;
    }
    atualizarRelogio();
    setInterval(atualizarRelogio, 1000);

    // Função para exibir dia da semana
    const diasDaSemana = ["Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"];
    const dataAtual = new Date();
    const diaNumero = dataAtual.getDay();
    const diaSemana = diasDaSemana[diaNumero];

    document.getElementById('dia_semana').textContent =`${diaSemana}`
 };