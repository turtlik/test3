package uz.center.Mahmud.controler;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.center.Mahmud.model.Talaba;
import uz.center.Mahmud.server.TalabaServer;

import java.util.List;

@RestController
@RequestMapping("/api/talaba")
@CrossOrigin(origins = "*",maxAge = 3600)
public class TalabaControler {

    TalabaServer ts = new TalabaServer();

    @GetMapping
    public String boshsaxifa() {

        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Talabalar haqida malumot</h1><br>\n"+
                "<table style='border: 1px solid red'>" +
                "<tr style='border: 1px solid red'>" +
                "<th>SHtrixKod</th><th>Name</th><th>LastName</th><th>Guruh</th><th>Tahrirlash</th><th>O'chirish</th>" +
                "</tr>";
        for (Talaba t : ts.getAll()) {
            html += "\n" +
                    "<div>\n" +"<tr>"+
                    "    <td>" + t.getShtrixkod() + "</td>\n" +
                    "    <td>" + t.getName() + "</td>\n" +
                    "    <td>" + t.getLastname() + "</td>\n" +
                    "    <td>" + t.getGuruhi() + "</td>\n" +
                    "    <div>" + t.getDate() + "</div>\n " +"</tr>"+
                    "</div>\n" +
                    "    \n";
        }

        html +="</table>" +
                "</div>"+
                "</body>\n" +
                        "</html>\n";
        return html;
    }


    @GetMapping("/")
    public List<Talaba> getTalaba() {
        return ts.getAll();
    }

    @GetMapping("/name/")
    public List<Talaba> getTalabaByFilter(@RequestParam("name") String name) {


        return ts.getAllByFilter(name);
    }

    @GetMapping("/{shtrixkod}")
    public Talaba getTalabaById(@PathVariable int shtrixkod) {
        return ts.getById(shtrixkod);
    }
// add-qushish
    @PostMapping("/")

    public void newqushish(@RequestBody Talaba talaba){
        ts.add(talaba);
    }

    @PutMapping("/")
    public void talabaUpdate(@RequestBody Talaba talaba)throws Exception{
        ts.update(talaba);
    }

    @DeleteMapping("/{shtrixkod}")
    public void delete(@PathVariable int shtrixkod) {
        ts.deleteById(shtrixkod);
    }


}
