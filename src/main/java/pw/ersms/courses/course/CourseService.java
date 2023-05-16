package pw.ersms.courses.course;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@Slf4j
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> get(){
        return courseRepository.findAll();
    }

    public Course getCourseById(Integer courseId){
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalStateException(
                        "course with id " + courseId + " does not exist"
                ));
    }

    public Object createCourse(@NotNull Course course){
        if(course.getTitle() == null || course.getTitle().isEmpty())
            throw new IllegalArgumentException("Title cannot be null or empty");
        if(course.getDescription() == null || course.getDescription().isEmpty())
            throw new IllegalArgumentException("Description cannot be null or empty");
        if(course.getAddressLine1() == null || course.getAddressLine1().isEmpty())
            throw new IllegalArgumentException("Address line cannot be null or empty");
        if(course.getCity() == null || course.getCity().isEmpty())
            throw new IllegalArgumentException("City cannot be null or empty");

        course.setId(null);
        course.setIsPublic(false);
        course.setIsRemote(false);
        course.setIsDeleted(false);

        return courseRepository.save(course);
    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No course present with id" + id)
        );

        if(course.getIsDeleted())
            throw new IllegalArgumentException("Course already deleted");

        course.setIsDeleted(true);

        courseRepository.deleteById(id);
    }

    public Object updateCourse(Integer id, @NotNull Course course){
        if(!courseRepository.existsById(id))
            throw new NoSuchElementException("Course not found with id " + id);
        if(course.getTitle() == null || course.getTitle().isEmpty())
            throw new IllegalArgumentException("Title cannot be null or empty");
        if(course.getDescription() == null || course.getDescription().isEmpty())
            throw new IllegalArgumentException("Description cannot be null or empty");
        if(course.getAddressLine1() == null || course.getAddressLine1().isEmpty())
            throw new IllegalArgumentException("Address line cannot be null or empty");
        if(course.getCity() == null || course.getCity().isEmpty())
            throw new IllegalArgumentException("City cannot be null or empty");

        course.setId(null);
        course.setIsPublic(false);
        course.setIsRemote(false);
        course.setIsDeleted(false);

        return courseRepository.save(course);
    }

    public Object getCourse(){
        Map<String, Object> resp = new HashMap<>();
        resp.put("success", true);
        resp.put("message", "Successful fetching data");

        return resp;
    }
}
