package uz.talaba.talabauz.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.talaba.talabauz.entity.Talaba;

public interface TalabaRepository extends JpaRepository<Talaba, Long> {
}
