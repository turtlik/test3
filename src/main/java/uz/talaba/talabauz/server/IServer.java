package uz.center.Mahmud.server;

import uz.center.Mahmud.model.Talaba;

import java.util.List;

public interface IServer<T> {
    public List<T> getAll();

    public T getById(int shitrixkod);

    public void add(T t);

    public void update(T t) throws Exception;

    public void delete(T t);

    public void deleteById(int id);


}
