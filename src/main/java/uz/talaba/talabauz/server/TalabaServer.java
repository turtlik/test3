package uz.center.Mahmud.server;

import org.springframework.web.bind.annotation.GetMapping;
import uz.center.Mahmud.model.Talaba;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TalabaServer implements IServer<Talaba> {
    ArrayList<Talaba> talabas = new ArrayList<>();

    {
        talabas.add(new Talaba(12, "Mahmud", "Abdullayev", "DI-13.18", Date.from(Instant.now()), true));
        talabas.add(new Talaba(63, "Shaxboz", "Ruzqulov", "DI-13.18", Date.from(Instant.now()), true));
        talabas.add(new Talaba(65, "Vazir", "Qalandarov", "DI-13.18", Date.from(Instant.now()), true));
        talabas.add(new Talaba(11, "Shaxzod", "Mirzayev", "DI-13.18", Date.from(Instant.now()), true));
        talabas.add(new Talaba(13, "Zarifa", "Jurayeva", "DI-13.18", Date.from(Instant.now()), true));

    }


    @Override
    public List<Talaba> getAll() {
        return talabas;
    }

    public List<Talaba> getAllByFilter(String s) {
        ArrayList<Talaba> ybr = new ArrayList<>();
        for (Talaba talaba : ybr) {

            if (talaba.getName().contains(s)) {
                ybr.add(talaba);
            }

        }
        return ybr;


    }


    @Override
    public Talaba getById(int shtrixkod) {
        for (int i = 0; i < talabas.size(); i++) {
            Talaba t = talabas.get(i);
            if (t.getShtrixkod() == shtrixkod) {
                return t;
            }
        }
        throw new NullPointerException("Bunday shtrixli kod topilmadi");
    }

    @Override
    // qushish
    public void add(Talaba talaba) {
        talabas.add(talaba);
    }

    @Override
    public void update(Talaba talaba) throws Exception {
        for (int i = 0; i < talabas.size(); i++) {
            if (talabas.get(i).getShtrixkod() == talaba.getShtrixkod()) {
                Talaba old = talabas.get(i);
                old.setName(talaba.getName());
                old.setLastname(talaba.getLastname());
                old.setDate(talaba.getDate());
                old.setActive(talaba.isActive());

                return;
            }
        }
        throw new Exception("Topilmadi");
    }

    @Override
    public void delete(Talaba talaba) {
        deleteById(talaba.getShtrixkod());
    }

    @Override
    public void deleteById(int shtrixkod) {
        System.out.println("O'chirish: " + shtrixkod);
        talabas.removeIf(talaba1 -> talaba1.getShtrixkod() == shtrixkod);
    }


}
