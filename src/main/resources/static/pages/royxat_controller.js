
let tbody = document.getElementById("tbody");



function yuklash() {
    talaba_service.getAll(jadvalToldir, xatoKorsat);
}


function create(){
    let n=document.forms['createForm']['ism'].value;
     let f=document.forms['createForm']['familiya'].value;
     let sh=document.forms['createForm']['sharif'].value;
    if(n){
        let t = {
         ism:n,
        familiya:f,
         sharif:sh
        };

        talaba_service.create(JSON.stringify(t), function(){

            $('#createModal').modal('toggle');
            yuklash();
        },xatoKorsat);

    }
}













function jadvalToldir(res) {
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
            <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#editModal"  onclick="tahrirlash(${t.id},'${t.ism}','${t.familiya}','${t.sharif}')">
            <i class="fa fa-pencil" aria-hidden="true"></i>
        </button>
        <button type="button" class="btn btn-danger btn-sm" onclick="ochirish(${t.id})">
        <i class="fa fa-trash" aria-hidden="true"></i>
    </button>
            </td>
           
        `;
    }


}
function xatoKorsat(res) {
    tbody.innerHTML = `
        <h1>Xatolik ro'y berdi</h1>
    `;
}




function tahrirlash(id, ism, familiya, sharif) {
    document.forms['editForm']["Id"].value = id;
    document.forms['editForm']["ism"].value = ism;
    document.forms['editForm']["familiya"].value = familiya;
    document.forms['editForm']["sharif"].value = sharif;
}



// Modaldan update buyrug'i kelganda ishlaydi

function update(){
    let id=document.forms['editForm']['id'].value;
    let n=document.forms['createForm']['ism'].value;
    let f=document.forms['createForm']['familiya'].value;
    let sh=document.forms['createForm']['sharif'].value;
    
    
    if(n){
        let t={
         ism:n,
         familiya:f,
         sharif:sh,
         id:id
        };
      talaba_service.update(JSON.stringify(t),function(){
   $('#editModal').modal('toggle');
   yuklash();

      },xatoKorsat);

    }
}



function ochirish(id) {
    console.log(id);
    let x = confirm(`Siz rostdan ham ${id} - raqamli talabani o'chirmoqchimisiz?`);
    if (x){
        talaba_service.deleteById(id, function(res){
        yuklash();
        }, function(error){ });
       }
}
