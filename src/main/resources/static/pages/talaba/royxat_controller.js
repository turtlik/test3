
let tbody = document.getElementById("tbody");

function yuklash(){
    talaba_service.getAll(jadvalToldir, xatoKorsat);
}

function jadvalToldir(res){
    let talabalar = JSON.parse(res);
    tbody.innerHTML = "";
    for (let i = 0; i < talabalar.length; i++) {
        let t = talabalar[i];
        tbody.innerHTML += `
            <td>${t.id}</td>
            <td>${t.ism}</td>
            <td>${t.familiya}</td>
            <td>${t.sharif}</td>
           
        `;
    }


}
function xatoKorsat(res){
    tbody.innerHTML = `
        <h1>Xatolik ro'y berdi</h1>
    `;
}