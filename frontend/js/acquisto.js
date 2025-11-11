const codReplica = localStorage.getItem("acquisto_codReplica");
const postiDisponibili = Number(localStorage.getItem("acquisto_postiDisponibili"));
const codCliente = localStorage.getItem("acquisto_codCliente");
const titolo = localStorage.getItem("acquisto_titolo");
const teatro = localStorage.getItem("acquisto_teatro");
const prezzo = localStorage.getItem("acquisto_prezzo");

document.getElementById('dettagliSpettacolo').innerHTML =
    `<div class="mb-1"><strong class="text-primary">${titolo}</strong></div>
     <div class="mb-1">Sala: ${teatro}</div>
     <div class="mb-1">Prezzo: <span class="badge bg-success">€${prezzo}</span></div>
     <div class="mb-2">Posti disponibili: <span class="badge bg-primary">${postiDisponibili}</span></div>`;

document.getElementById('numeroBiglietti').max = postiDisponibili;
document.getElementById('codReplica').value = codReplica;
document.getElementById('postiDisponibili').value = postiDisponibili;
document.getElementById('codCliente').value = codCliente;

let selectedPay = "";
document.getElementById('btnCarta').addEventListener('click', function() {
    selectedPay = "Carta di credito";
    document.getElementById('metodoPagamento').value = selectedPay;
    document.getElementById('btnCarta').classList.add('active');
    document.getElementById('btnPayPal').classList.remove('active');
});
document.getElementById('btnPayPal').addEventListener('click', function() {
    selectedPay = "PayPal";
    document.getElementById('metodoPagamento').value = selectedPay;
    document.getElementById('btnPayPal').classList.add('active');
    document.getElementById('btnCarta').classList.remove('active');
});

document.getElementById('formAcquisto').addEventListener('submit', async function(e) {
    e.preventDefault();
    const metodoPagamento = document.getElementById('metodoPagamento').value;
    const numeroBiglietti = Number(document.getElementById('numeroBiglietti').value);
    if(!metodoPagamento) return showError("Seleziona il metodo di pagamento.");
    if(numeroBiglietti < 1 || numeroBiglietti > postiDisponibili) return showError("Numero biglietti non valido.");
    const res = await fetch("http://localhost:8080/api/biglietti", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            codCliente: parseInt(codCliente, 10),
            codReplica: codReplica,
            tipoPagamento: metodoPagamento,
            quantita: numeroBiglietti
        })
    });
    if(res.ok) {
        document.getElementById('dettagliSpettacolo').innerHTML +=
            `<div class="mt-3 alert alert-success text-center">Prenotazione avvenuta!</div>`;
        setTimeout(()=>window.location.href="index.html", 1800);
    } else {
        const errMsg = await res.text();
        showError(errMsg || "Errore nella prenotazione!");
    }
});
function showError(msg) {
    document.getElementById('acquistoError').innerText = msg;
    document.getElementById('acquistoError').style.display = "";
}