package uz.talaba.talabauz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.talaba.talabauz.entity.User;
import uz.talaba.talabauz.repostiory.UserRepository;

@Service
public class UserProvider implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUsername(username);
        if(u != null)
        return new UserMaxsus(u.getUsername(), u.getPassword());

        throw new UsernameNotFoundException("Topilmadi");


    }
}
