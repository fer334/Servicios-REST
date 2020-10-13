document.getElementById("selectTipo").addEventListener("change", (e) => {
  if (e.target.selectedIndex == 4) {
    document.getElementById("showInputMovil").classList.add("show");
  } else document.getElementById("showInputMovil").classList.remove("show");
});

document.getElementById("submitRegistrar").addEventListener("click", () => {
  var xhttp = new XMLHttpRequest();
  xhttp.open("POST", "http://127.0.0.1:8080/movil/rest/", true);
  xhttp.setRequestHeader("Content-Type", "application/json");
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4) {
      alert("Server response: " + this.responseText);
      // Response
      var response = this.responseText;
    }
  };
  var data = { identificador: "", tipo: "" };
  data.identificador = document.getElementById("idMovil").value;

  sel = document.getElementById("selectTipo");
  if (sel.selectedIndex == 4) {
    data.tipo = document.getElementById("idTipo").value;
  } else data.tipo = sel.options[sel.selectedIndex].value;
  xhttp.send(JSON.stringify(data));
});

/**
 * Menu
 */

document.getElementById("menu-res").addEventListener("click", () => {
  document.getElementById("fieldres").classList.add("show");
  document.getElementById("fieldubi").classList.remove("show");
  document.getElementById("fieldlis").classList.remove("show");
  document.getElementById("table").classList.remove("show");
});
document.getElementById("menu-ubi").addEventListener("click", () => {
  document.getElementById("fieldres").classList.remove("show");
  document.getElementById("fieldubi").classList.add("show");
  document.getElementById("fieldlis").classList.remove("show");
  document.getElementById("table").classList.remove("show");

  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "http://127.0.0.1:8080/movil/rest/", true);
  xhttp.setRequestHeader("Content-Type", "application/json");
  xhttp.onload = function () {
    if (this.status >= 200 && this.status < 300) {
      datos = JSON.parse(this.response);
      document.getElementById("selectMovil").innerHTML =
        '<option default="">Seleccione uno</option>';

      for (const movil of datos) {
        const node = document.createElement("option");
        node.text = movil.identificador + " --- " + movil.tipo;
        document.getElementById("selectMovil").appendChild(node);
      }
    } else alert("Request movil data failed");
  };
  xhttp.send();
});
document.getElementById("menu-lis").addEventListener("click", () => {
  document.getElementById("fieldres").classList.remove("show");
  document.getElementById("fieldubi").classList.remove("show");
  document.getElementById("fieldlis").classList.add("show");
  document.getElementById("table").classList.remove("show");
});

/**
 * Ubicar
 */

document.getElementById("submitUbicar").addEventListener("click", (e) => {
  var xhttp = new XMLHttpRequest();
  xhttp.open("POST", "http://127.0.0.1:8080/movil/rest/ubicacion", true);
  xhttp.setRequestHeader("Content-Type", "application/json");
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4) {
      alert("Server response: " + this.responseText);
    }
  };

  var data = { latitud: "", longitud: "", movil: 0 };
  data.latitud = document.getElementById("idLatitud").value;
  data.longitud = document.getElementById("idLongitud").value;

  sel = document.getElementById("selectMovil");
  if (sel.selectedIndex != 0) {
    let aux = sel.options[sel.selectedIndex].value;
    data.movil = +(aux = aux.split(" -")[0]);

    xhttp.send(JSON.stringify(data));
  }
});

/**
 * Listar
 */

document.getElementById("submitListar").addEventListener("click", (e) => {
  document.getElementById("table").classList.add("show");

  const lat = document.getElementById("idLatitudL").value;
  const lon = document.getElementById("idLongitudL").value;
  const dis = document.getElementById("idRango").value;
  var xhttp = new XMLHttpRequest();
  xhttp.open(
    "GET",
    `http://127.0.0.1:8080/movil/rest/mov-cercano/${lat}/${lon}/${dis}`,
    true
  );
  xhttp.setRequestHeader("Content-Type", "application/json");
  xhttp.onload = function () {
    if (this.status >= 200 && this.status < 300) {
      datos = JSON.parse(this.response);

      document.getElementById("fila").innerHTML="";

      let c = 0;
      for (const d of datos) {
        c++;

        tr = document.createElement("tr");
        tr.innerHTML = `<th scope="row">${c}</th>`;

        a = new Date(d.ubicacion.timestamp);
        cleaned = [
          d.movil.identificador,
          d.movil.tipo,
          d.ubicacion.latitud,
          d.ubicacion.longitud,
          ("0" + a.getDate()).slice(-2) +
            "/" +
            ("0" + (+a.getUTCMonth() + 1)).slice(-2) +
            "/" +
            a.getUTCFullYear(),
          ("0" + a.getHours()).slice(-2) +
            ":" +
            ("0" + a.getMinutes()).slice(-2),
        ];

        for (const x of cleaned) {
          th = document.createElement("td");
          th.innerHTML = x;
          tr.appendChild(th);
        }

        document.getElementById("fila").appendChild(tr);
      }
    } else alert("Request movil data failed");
  };
  xhttp.send();
});
