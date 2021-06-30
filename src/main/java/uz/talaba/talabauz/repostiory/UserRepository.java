package uz.talaba.talabauz.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.talaba.talabauz.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
