package uz.talaba.talabauz.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.talaba.talabauz.entity.Talaba;

import java.util.List;

public interface TalabaRepository extends JpaRepository<Talaba, Long> {
public List<Talaba> findAllByIsmContains(String Ism);
public List<Talaba> findByOrderById();
}
