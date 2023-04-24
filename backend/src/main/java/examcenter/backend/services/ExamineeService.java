package examcenter.backend.services;

import examcenter.backend.models.Examinee;
import examcenter.backend.repository.ExamineeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExamineeService {
    @Autowired
    private ExamineeRepository examineeRepository;

    public List<Examinee> getAllExaminees(){
        return examineeRepository.findAll();
    }


    public Examinee addExaminee(Examinee examinee) {
        return examineeRepository.save(examinee);
    }
    public void deleteExaminee(Long id) {
        examineeRepository.deleteById(id);
    }
}
