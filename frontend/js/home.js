// Visualizzazione semplice: griglia di card spettacolo, tutte visibili!

async function caricaSpettacoliHome() {
    const spettRes = await fetch('http://localhost:8080/api/spettacoli');
    const spettacoli = spettRes.ok ? await spettRes.json() : [];
    const teatroRes = await fetch('http://localhost:8080/api/teatri');
    const teatri = teatroRes.ok ? await teatroRes.json() : [];
    const repRes = await fetch('http://localhost:8080/api/repliche');
    const repliche = repRes.ok ? await repRes.json() : [];
    const biglRes = await fetch('http://localhost:8080/api/biglietti');
    const biglietti = biglRes.ok ? await biglRes.json() : [];

    let html = '';
    spettacoli.forEach(spett => {
        const teatro = teatri.find(t => t.codTeatro === spett.codTeatro);
        const replicheSpec = repliche.filter(r => r.codSpettacolo === spett.codSpettacolo);
        html += `<div class="col-md-6 col-lg-4 mb-4">
            <div class="card h-100 shadow-sm">
              <div class="card-body">
                <h4 class="card-title text-primary"><i class="bi bi-calendar-week me-2"></i>${spett.titolo}</h4>
                <div>
                  <strong>Teatro:</strong> ${teatro ? teatro.nome : 'N/D'}<br>
                  <strong>Autore:</strong> ${spett.autore}<br>
                  <strong>Regista:</strong> ${spett.regista}<br>
                  <strong>Prezzo:</strong> <span class="badge bg-success text-white">€${spett.prezzo}</span>
                </div>
                <hr>
                <div>
                  <strong>Date disponibili:</strong><br>`;
        if(replicheSpec.length === 0) {
            html += `<span class="text-secondary small">Nessuna replica disponibile</span>`;
        }
        replicheSpec.forEach(replica => {
            const bigliettiReplica = biglietti.filter(b => b.codReplica === replica.codReplica);
            const prenotati = bigliettiReplica.reduce((sum, b) => sum + b.quantita, 0);
            const postiDisponibili = teatro ? teatro.posti - prenotati : 0;
            html += `<div class="d-flex align-items-center my-1">
                        <span class="me-2 badge bg-info">${replica.dataReplica}</span>
                        <span class="badge bg-primary ms-2">${postiDisponibili} posti</span>
                        <button class="btn btn-outline-success btn-sm ms-auto" 
                            onclick="vaiAcquisto('${replica.codReplica}',${postiDisponibili},'${spett.titolo}','${teatro ? teatro.nome : ''}','${spett.prezzo}')"
                            ${postiDisponibili <= 0 ? 'disabled' : ''}>
                            <i class="bi bi-cart4"></i> Acquista
                        </button>
                     </div>`;
        });
        html += `</div>
              </div>
            </div>
        </div>`;
    });
    document.getElementById("spettacoliGrid").innerHTML = html;
}

window.vaiAcquisto = function(codReplica, postiDisponibili, titolo, teatro, prezzo) {
    localStorage.setItem("acquisto_codReplica", codReplica);
    localStorage.setItem("acquisto_postiDisponibili", postiDisponibili);
    localStorage.setItem("acquisto_titolo", titolo);
    localStorage.setItem("acquisto_teatro", teatro);
    localStorage.setItem("acquisto_prezzo", prezzo);
    window.location.href = "login.html";
};

window.onload = caricaSpettacoliHome;