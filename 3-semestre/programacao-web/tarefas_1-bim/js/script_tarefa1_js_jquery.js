$(document).ready(function () {
  $("#converter").click(function () {
    let x = $("#select_moeda").val();
    operacao(x);
  });
});

function operacao(y) {
  let a = parseFloat($("#valor").val());
  let resultado = 0;

  if (y === "euro") {
    resultado = a * 5.26;
  } else if (y === "dolar") {
    resultado = a * 4.93;
  }

  $("#campo").val(resultado.toFixed(2));
}