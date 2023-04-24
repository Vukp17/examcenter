package examcenter.backend.repository;

import examcenter.backend.models.Exam;
import examcenter.backend.models.ExamExaminee;
import examcenter.backend.models.Examinee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamExamineeRepository extends JpaRepository<ExamExaminee, Long> {
    List<ExamExaminee> findAll();
    List<ExamExaminee> findByExamId(Long examId);
    List<ExamExaminee> findByExamineeId(Long examineeId);

}
