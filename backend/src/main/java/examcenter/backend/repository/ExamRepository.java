package examcenter.backend.repository;

import examcenter.backend.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findAll();
    Optional<Exam> findById(Long id);
    void deleteById(Long id);

}
