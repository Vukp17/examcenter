package examcenter.backend.repository;

import examcenter.backend.models.Exam;
import examcenter.backend.models.ExamCancellation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamCancellationRepository extends JpaRepository<ExamCancellation, Long> {
    List<ExamCancellation> findAll();
}
