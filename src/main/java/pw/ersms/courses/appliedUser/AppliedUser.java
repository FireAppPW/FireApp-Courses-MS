package pw.ersms.courses.appliedUser;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pw.ersms.courses.course.Course;

import java.time.LocalDateTime;

@Entity
@Table(name = "\"AppliedUsers\"")
@Getter
@Setter
public class AppliedUser {

    @EmbeddedId
    private AppliedUserId id;

    @MapsId("courseId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "user_full_name", nullable = false, length = Integer.MAX_VALUE)
    private String userFullName;

    @Column(name = "user_department_name", nullable = false, length = Integer.MAX_VALUE)
    private String userDepartmentName;

    @Column(name = "date_time_applied", nullable = false)
    private LocalDateTime dateTimeApplied;
}
