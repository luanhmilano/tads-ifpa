$(document).ready(function () {
    $("#calcular").click(function () {
        let x = $("#operacao").val();
        calculo(x);
    });
});

function calculo(operacao) {
    let a = parseFloat($("#a").val());
    let b = parseFloat($("#b").val());
    let resultado = 0;

    switch (operacao) {
        case "soma":
            resultado = a + b;
            break;
        case "sub":
            resultado = a - b;
            break;
        case "multi":
            resultado = a * b;
            break;
        case "divi":
            if (b !== 0) {
                resultado = a / b;
            } else {
                alert("Não é possível dividir por zero.");
                return;
            }
            break;
        default:
            alert("Operação inválida.");
            return;
    }

    $("#result").val(resultado);
}