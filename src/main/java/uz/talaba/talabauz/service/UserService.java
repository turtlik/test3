package uz.talaba.talabauz.service;

import uz.talaba.talabauz.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User getById(Long id) throws Exception;
    public User create(User user) throws Exception;
    public User update(User user) throws Exception;
    public void delete(User user);
    public void deleteById(Long id);

    User loadByUsername(String username);
}
