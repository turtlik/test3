
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
            <td>
            <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal"  onclick="tahrirlash(${t.id})">
            <i class="fa fa-pencil" aria-hidden="true"></i>
        </button>
        <button type="button" class="btn btn-danger btn-sm" onclick="ochirish(${t.id})">
        <i class="fa fa-trash" aria-hidden="true"></i>
    </button>
            </td>
           
        `;
    }


}
function xatoKorsat(res){
    tbody.innerHTML = `
        <h1>Xatolik ro'y berdi</h1>
    `;
}

function tahrirlash(id){
    document.forms['editForm']["ID"].value = id;
}

function ochirish(id){

}