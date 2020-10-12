document.getElementById("selectTipo").addEventListener("change", (e) => {
  console.log(e.target.selectedIndex);
  if (e.target.selectedIndex == 4) {
    document.getElementById("showInputMovil").classList.add("show");
  } else document.getElementById("showInputMovil").classList.remove("show");
});

document.getElementById("submitRegistrar").addEventListener("click", () => {
//   var xhttp = new XMLHttpRequest();
//   xhttp.onreadystatechange = function () {
//     if (this.readyState == 4 && this.status == 200) {
//       r = this.responseText;
//       console.log(r);
      
//     }
//   };
//   xhttp.open("GET", "localhost:8080/movil/rest/", true);
//   xhttp.send();

  var xhttp = new XMLHttpRequest();
  xhttp.open("POST", "http://127.0.0.1:8080/movil/rest/", true);
  xhttp.setRequestHeader("Content-Type", "application/json");
  xhttp.onreadystatechange = function () {
      
    if (this.readyState == 4 ) {
        alert("Server response: "+this.responseText);
      // Response
      var response = this.responseText;
    }else
        console.log("response status" + this.readyState);
  };
  var data = { identificador: "", tipo: "" };
  data.identificador = document.getElementById("idMovil").value;

  sel = document.getElementById("selectTipo");
  if (sel.selectedIndex == 4) {
    data.tipo = document.getElementById("idTipo").value;
  } else data.tipo = sel.options[sel.selectedIndex].value;
  xhttp.send(JSON.stringify(data));
});

/*
/ Menu
*/

document.getElementById("menu-res").addEventListener("click", ()=>{
    document.getElementById('fieldres').classList.add('show');
    document.getElementById('fieldubi').classList.remove('show');
    document.getElementById('fieldlis').classList.remove('show');
});
document.getElementById("menu-ubi").addEventListener("click", ()=>{
    document.getElementById('fieldres').classList.remove('show');
    document.getElementById('fieldubi').classList.add('show');
    document.getElementById('fieldlis').classList.remove('show');

    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://127.0.0.1:8080/movil/rest/", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.onload = function () {
      if (this.status >= 200 && this.status < 300) {
          console.log(this.response);
          datos = JSON.parse(this.response)
          console.log(datos);

          for (const movil of datos) {
              console.log(movil);
                const node  = document.createElement("option")
                node.text = movil.identificador+" --- "+ movil.tipo;
              document.getElementById("selectMovil").appendChild( node );
              
          }
          
          
      } else alert("Request movil data failed");
    };
    xhttp.send();

});
document.getElementById("menu-lis").addEventListener("click", ()=>{
    document.getElementById('fieldres').classList.remove('show');
    document.getElementById('fieldubi').classList.remove('show');
    document.getElementById('fieldlis').classList.add('show');
});
