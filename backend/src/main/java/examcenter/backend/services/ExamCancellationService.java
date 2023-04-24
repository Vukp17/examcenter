package examcenter.backend.services;

import examcenter.backend.models.ExamCancellation;
import examcenter.backend.repository.ExamCancellationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamCancellationService {
    @Autowired
    private ExamCancellationRepository examCancellationRepository;

    public List<ExamCancellation> findAllExamCancellations() {
        return examCancellationRepository.findAll();
    }
}
