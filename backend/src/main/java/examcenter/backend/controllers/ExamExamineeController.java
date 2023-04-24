package examcenter.backend.controllers;

import examcenter.backend.models.Exam;
import examcenter.backend.models.ExamExaminee;
import examcenter.backend.services.ExamExamineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/examexaminee")
public class ExamExamineeController {

    @Autowired
    private ExamExamineeService examExamineeService;

    @GetMapping("/exam/{examId}")
    public List<ExamExaminee> findByExamId(@PathVariable Long examId) {
        return examExamineeService.findByExamId(examId);
    }

    @GetMapping("/examinee/{examineeId}")
    public List<ExamExaminee> findByExamineeId(@PathVariable Long examineeId) {
        return examExamineeService.findByExamineeId(examineeId);
    }


}
