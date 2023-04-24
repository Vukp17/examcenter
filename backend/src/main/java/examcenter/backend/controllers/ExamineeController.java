package examcenter.backend.controllers;

import examcenter.backend.models.Examinee;
import examcenter.backend.services.ExamineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/examinees")
public class ExamineeController {
    @Autowired
    private ExamineeService examineeService;

    @GetMapping
    public List<Examinee> getAllExaminees() {
        return examineeService.getAllExaminees();
    }


    @PostMapping
    public Examinee addExaminee(@RequestBody Examinee examinee) {
        System.out.println("Tu smo "+examinee);
        return examineeService.addExaminee(examinee);
    }

    @DeleteMapping("/{id}")
    public void deleteExaminee(@PathVariable Long id) {
        examineeService.deleteExaminee(id);
    }

}
