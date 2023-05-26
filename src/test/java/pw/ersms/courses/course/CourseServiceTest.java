package pw.ersms.courses.course;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CourseServiceTest {
    @Mock
    private CourseRepository courseRepository;
    @InjectMocks
    private  CourseService courseService;

    private Course course;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        course = new Course(10, "x", "x", true, null, null, null, 5, true, "x", "x", "x", "x", "x", false);
    }

    @Test
    void get() {
        when(courseRepository.findAll()).thenReturn(Arrays.asList(course));
        assertNotNull(courseService.get());
    }

    @Test
    void getCourseById() {
        when(courseRepository.findById(course.getId())).thenReturn(Optional.ofNullable(course));
        assertNotNull(courseService.getCourseById(course.getId()));
    }

    @Test
    void createCourse() {
        when(courseRepository.save(any(Course.class))).thenReturn(course);
        assertNotNull(courseService.createCourse(course));
    }

    @Test
    void deleteCourse() {
        when(courseRepository.findById(course.getId())).thenReturn(Optional.ofNullable(course));
        courseService.deleteCourse(course.getId());
    }

    @Test
    void updateCourse() {
        when(courseRepository.save(any(Course.class))).thenReturn(course);
        assertNotNull(courseService.updateCourse(course.getId(), course));
    }
}