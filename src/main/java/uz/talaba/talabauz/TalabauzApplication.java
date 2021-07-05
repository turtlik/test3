package uz.talaba.talabauz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.talaba.talabauz.entity.User;
import uz.talaba.talabauz.service.UserService;

@SpringBootApplication
public class TalabauzApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(TalabauzApplication.class, args);
    }


    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        User u = new User();
        u.setUsername("admin");
        u.setPassword(passwordEncoder.encode("admin"));
        if(userService.loadByUsername("admin")==null)
        userService.create(u);
    }
}
