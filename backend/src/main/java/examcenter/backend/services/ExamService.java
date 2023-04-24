package examcenter.backend.services;

import examcenter.backend.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import examcenter.backend.models.Exam;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam getExamById(Long id) {
        Optional<Exam> examOptional = examRepository.findById(id);
        return examOptional.orElse(null);
    }

    public boolean deleteExamById(Long id) {
        Optional<Exam> examOptional = examRepository.findById(id);
        if (examOptional.isPresent()) {
            examRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Exam addExam(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam updateExam(Long id, Exam exam) {
        Exam existingExam = examRepository.findById(id).orElse(null);
        if (existingExam != null) {
            existingExam.setLocation(exam.getLocation());
            existingExam.setField(exam.getField());
            existingExam.setDateAndTime(exam.getDateAndTime());
            existingExam.setCancelled(exam.isCancelled());
            examRepository.save(existingExam);
            return existingExam;
        } else {
            return null;
        }
    }



}
