
function registrer(){
    console.log("register ran")
    const billett = {
        antall : $("#antall").val(),
        film : $("#film").val(),
        fornavn : $("#fornavn").val(),
        etternavn : $("#etternavn").val(),
        telefon : $("#telefon").val(),
        epost : $("#epost").val()

    };

    let valid = valider(billett);

    if (valid === true){
        $.post("/Lagre"), billett, function(){
            hentAlle()
        }
        $("#antall").val("");
        $("#film").val("");
        $("#fornavn").val("");
        $("#etternavn").val("");
        $("#telefon").val("");
        $("#epost").val("");
    }
}

function hentAlle(){
    $.get("/hentAlle", function(data){
        formaterData(data);
    })
}

function formaterData(billetter){
    let ut = "<table>" +
        "<tr>" +
        "<th>Antall</th>" +
        "<th>Film</th>" +
        "<th>Fornavn</th>" +
        "<th>Etternavn</th>" +
        "<th>Telefon</th>" +
        "<th>Epost</th>" +
        "</tr>";

    for (const billett of billetter){
        ut+="<tr>" +
            "<th>billett.antall</th>" +
            "<th>billett.film</th>" +
            "<th>billett.fornavn</th>" +
            "<th>billett.etternavn</th>" +
            "<th>billett.telefon</th>" +
            "<th>billett.epost</th>" +
            "</tr>";
    }

    ut+="</table>";
    $("#billettregister").html(ut);



}

function slett(){
    $.get("/slett", function(){
        hentAlle();
    })
}

function valider(billett){
    console.log("valider ran")
    let valid = true

    //Antall
    if (billett.antall === ""||isNaN(billett.antall)){
        $("#feilmelding_antall").show();
    }else if (billett.antall === "0"){
        valid =  false
        $("#feilmelding_antall").show();
    }else{
        $("#feilmelding_antall").hide();
    }

    //Film
    console.log(billett.film);
    if (billett.film === "invalid"){
        valid = false
        $("#feilmelding_film").show();

    } else{
        $("#feilmelding_film").hide();
    }

    //Fornavn
    if (billett.fornavn === ""){
        valid = false
        $("#feilmelding_fornavn").show();
    }else{
        $("#feilmelding_fornavn").hide();
    }

    //Etternavn
    if (billett.etternavn === ""){
        valid = false
        $("#feilmelding_etternavn").show();
    }else{
        $("#feilmelding_etternavn").hide();
    }

    //Telefon
    const norwegianPhoneRegex = /^(?:\+47)?\s?(\d{2}\s?\d{2}\s?\d{2}\s?\d{2}|\d{3}\s?\d{2}\s?\d{3}|\d{5}\s?\d{3})$/;
    if (!norwegianPhoneRegex.test(billett.telefon)) {
        valid = false;
        $("#feilmelding_telefon").show();

    }else if(billett.telefon === ""||isNaN(billett.telefon)){
        valid = false;
        $("#feilmelding_telefon").show();
    }else{
        $("#feilmelding_telefon").hide();
    }

    //Epost
    const emailRegex = /^[^\s@]+@[^\s@]+.[^\s@]+$/;
    if (!emailRegex.test(billett.epost)){
        valid = false;
        $("#feilmelding_epost").show();

    }else if (billett.epost === ""){
        valid = false
        $("#feilmelding_epost").show();
    }else {
        $("#feilmelding_epost").hide();
    }
    console.log(valid);

    return valid
}