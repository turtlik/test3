package uz.talaba.talabauz.service.impl;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.talaba.talabauz.entity.Talaba;
import uz.talaba.talabauz.repostiory.TalabaRepository;
import uz.talaba.talabauz.service.TalabaService;

import java.util.List;
import java.util.Optional;

@Service
public class TalabaServiceImpl implements TalabaService {
    @Autowired
    TalabaRepository talabaRepository;

    @Override
    public List<Talaba> getAll() {
        return talabaRepository.findAll();
    }

    @Override
    public Talaba getById(Long id) {

        Optional<Talaba> t = talabaRepository.findById(id);
        if (t.isPresent()){
            return t.get();
        }
        throw new RuntimeException("Not Found");

    }

    @Override
    public Talaba create(Talaba talaba) {
        if(talaba.getId() == null){
            return talabaRepository.save(talaba);
        }

        throw new RuntimeException("Yangi talabada id bo'lishi mumkin emas");
    }

    @Override
    public Talaba update(Talaba talaba) {
        if(talaba.getId() != null && talabaRepository.existsById(talaba.getId())){

            return talabaRepository.save(talaba);
        }

        throw new RuntimeException("O'zgarayotgan talabada id bo'lishi shart");
    }

    @Override
    public void delete(Talaba talaba) {
        talabaRepository.delete(talaba);
    }

    @Override
    public void deleteById(Long id) {
        talabaRepository.deleteById(id);
    }
}
