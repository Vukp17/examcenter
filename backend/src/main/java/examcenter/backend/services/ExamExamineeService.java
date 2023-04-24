package examcenter.backend.services;

import examcenter.backend.models.ExamExaminee;
import examcenter.backend.repository.ExamExamineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamExamineeService {

    @Autowired
    private ExamExamineeRepository examExamineeRepository;

    public List<ExamExaminee> findByExamId(Long examId) {
        return examExamineeRepository.findByExamId(examId);
    }
    public List<ExamExaminee> findByExamineeId(Long examineeId) {
        return examExamineeRepository.findByExamineeId(examineeId);
    }
}
