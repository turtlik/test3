package uz.talaba.talabauz.service;

import uz.talaba.talabauz.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User getById(Long id);
    public User create(User user);
    public User update(User user);
    public void delete(User user);
    public boolean deleteById(Long id);
}
