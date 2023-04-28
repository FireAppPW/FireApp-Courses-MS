package pw.ersms.courses.course;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping(path = "/course")
    public ResponseEntity<Object> getCourse(){
        return ResponseEntity.ok().body(courseService.getCourse());
    }
}
