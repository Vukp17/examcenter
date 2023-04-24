package examcenter.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "exam_cancellations")
public class ExamCancellation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @Column(name = "reason")
    private String reason;

    public ExamCancellation(Long id, Exam exam, String reason) {
        this.id = id;
        this.exam = exam;
        this.reason = reason;
    }

    public ExamCancellation() {
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
