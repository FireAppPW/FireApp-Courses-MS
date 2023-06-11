package pw.ersms.courses.course;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("course")
@SecurityRequirement(name = "Bearer Authentication")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<Course> getCourse(){
        return courseService.get();
    }

    @GetMapping(path = "/{id}")
    public Course getCourseById(@PathVariable("id") Integer id){
        return courseService.getCourseById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createCourse(@RequestBody Course course){
        return ResponseEntity.ok(courseService.createCourse(course));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCourse(@PathVariable("id") Integer id){
        courseService.deleteCourse(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable("id") Integer id, @RequestBody Course course){
        return ResponseEntity.ok(courseService.updateCourse(id, course));
    }
}
