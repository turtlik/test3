package uz.talaba.talabauz.service;

import uz.talaba.talabauz.entity.Talaba;

import java.util.List;

public interface TalabaService {
    public List<Talaba> getAll();
    public Talaba getById(Long id);
    public Talaba create(Talaba talaba);
    public Talaba update(Talaba talaba);
    public void delete(Talaba talaba);
    public void deleteById(Long id);


}
