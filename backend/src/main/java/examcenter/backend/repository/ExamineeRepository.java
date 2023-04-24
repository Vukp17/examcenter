package examcenter.backend.repository;

import examcenter.backend.models.Exam;
import examcenter.backend.models.Examinee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamineeRepository extends JpaRepository<Examinee, Long> {
    List<Examinee> findAll();
}
