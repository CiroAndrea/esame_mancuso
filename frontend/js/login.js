document.getElementById('formLogin').addEventListener('submit', async function(e) {
    e.preventDefault();
    const codCliente = document.getElementById('codiceCliente').value.trim();

    if (!codCliente) return;
    const res = await fetch('http://localhost:8080/api/login/' + codCliente);
    if(res.ok) {
        localStorage.setItem('acquisto_codCliente', codCliente);
        window.location.href = "acquisto.html";
    } else {
        document.getElementById('loginError').innerText = "Codice cliente non valido!";
        document.getElementById('loginError').style.display = "";
    }
});