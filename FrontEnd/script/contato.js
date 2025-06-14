const form = document.getElementById("right-container");

form.addEventListener("submit", (e) => {
  e.preventDefault(); // Impede o envio automático do formulário

  const inputs = form.querySelectorAll("input[type='text'], input[type='email'], input[type='tel']");
  const textarea = document.getElementById("text_area_id");

  const nome = inputs[0].value.trim(); 
  const sobrenome = inputs[1].value.trim(); 
  const email = inputs[2].value.trim(); 
  const telefone = inputs[3].value.trim();
  const mensagem = textarea.value.trim();

  let isValid = true;

  // Validar nome
  if (nome.length <= 3) {
    alert("Por favor, preencha o nome com mais de 3 caracteres.");
    isValid = false;
  }

  // Validar sobrenome
  if (isValid && sobrenome.length <= 3) {
    alert("Por favor, preencha o sobrenome com mais de 3 caracteres.");
    isValid = false;
  }

  // Validar email  
  if (isValid) {
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
      alert("Por favor, insira um email válido.");
      isValid = false;
    }
  }

  // Validar mensagem
  if (isValid && mensagem.length === 0) {
    alert("Por favor, preencha a mensagem");
    isValid = false;
  }

  // Se tudo estiver válido, mostrar alerta de sucesso
  if (isValid) {
    alert("Contato enviado com sucesso!");
    form.submit(); // Envia o formulário
  }
});