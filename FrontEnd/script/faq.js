const headers = document.querySelectorAll('.accordion-header');
const bodies = document.querySelectorAll('.accordion-body');

// Inicia todos os corpos do accordion fechados
bodies.forEach(body => {
    body.style.minHeight = '0';
    body.style.maxHeight = '0'; 
});

// Adiciona evento de clique a cada cabeçalho
headers.forEach(header => {
    header.addEventListener('click', () => {
        const body = header.nextElementSibling;

        // Fecha todos os outros corpos exceto o atual
        headers.forEach(otherHeader => {
            const otherBody = otherHeader.nextElementSibling;
            if (otherBody !== body) {
                otherBody.style.minHeight = '0'; 
                otherBody.style.maxHeight = '0'; 
            }
        });

        // Alterna (abre/fecha) o corpo atual
        if (body.style.maxHeight === '0px' || body.style.maxHeight === '') {
            const scrollHeight = body.scrollHeight;
            body.style.minHeight = (10 + scrollHeight) + "px"; 
            body.style.maxHeight = scrollHeight + "px"; 
        } else {
            body.style.minHeight = '0';
            body.style.maxHeight = '0'; 
        }
    });
});