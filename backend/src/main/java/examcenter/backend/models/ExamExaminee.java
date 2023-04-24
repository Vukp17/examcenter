package examcenter.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "exam_examinee")
public class ExamExaminee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "exam_id",nullable = false)
    @ManyToOne
    private Exam exam;
    @JoinColumn(name = "examinee_id",nullable = false)
    @ManyToOne
    private Examinee examinee;

    public ExamExaminee() {
    }

    public ExamExaminee(Long id, Exam exam, Examinee examinee) {
        this.id = id;
        this.exam = exam;
        this.examinee = examinee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Examinee getExaminee() {
        return examinee;
    }

    public void setExaminee(Examinee examinee) {
        this.examinee = examinee;
    }
}
