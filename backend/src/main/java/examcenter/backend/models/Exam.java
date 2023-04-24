package examcenter.backend.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "location")
    private String location;
    @Column(name = "field")
    private String field;
    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;
    @Column(name = "cancelled")
    private boolean cancelled;


    public Exam(Long id, String location, String field, LocalDateTime dateAndTime, boolean cancelled) {
        this.id = id;
        this.location = location;
        this.field = field;
        this.dateAndTime = dateAndTime;
        this.cancelled = cancelled;
    }

    public Exam() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

}
