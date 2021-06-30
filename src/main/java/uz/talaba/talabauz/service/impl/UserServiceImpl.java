package uz.talaba.talabauz.service.impl;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.talaba.talabauz.entity.User;
import uz.talaba.talabauz.repostiory.UserRepository;
import uz.talaba.talabauz.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;



    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) throws Exception {
        Optional<User> user =  userRepository.findById(id);

        if(user.isPresent()){
            return user.get();
        }
        throw new Exception("User topilmadi");
    }

    @Override
    public User create(User data) throws Exception {
        if(data.getId() == null){
          return   userRepository.save(data);
        }
        throw new Exception("id null bo'lishi kerak");


    }

    @Override
    public User update(User data) throws Exception {
        if(data.getId() != null){
           return userRepository.save(data);
        }
        throw new Exception("id null bo'lmasligi kerak");

    }

    @Override
    public void delete(User data) {
        userRepository.delete(data);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User loadByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
