package uz.center.Mahmud.model;

import java.util.Date;

public class Talaba {
    private int shtrixkod;
    private String name;
    private String lastname;
    private String guruhi;
    private Date date;
    private boolean active;

    public Talaba() {
    }

    public Talaba(int shtrixkod, String name, String lastname, String guruhi, Date date, boolean active) {
        this.shtrixkod = shtrixkod;
        this.name = name;
        this.lastname = lastname;
        this.guruhi = guruhi;
        this.date = date;
        this.active = active;
    }

    public int getShtrixkod() {
        return shtrixkod;
    }

    public void setShtrixkod(int shtrixkod) {
        this.shtrixkod = shtrixkod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGuruhi() {
        return guruhi;
    }

    public void setGuruhi(String guruhi) {
        this.guruhi = guruhi;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}


