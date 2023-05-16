package pw.ersms.courses.course;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "\"Courses\"")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @SequenceGenerator(
            name = "Course_id_seq",
            sequenceName = "Course_id_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Course_id_seq"
    )
    private Integer id;

    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "is_public", nullable = false)
    private Boolean isPublic = false;

    @Column(name = "date_time_created", nullable = false)
    private LocalDateTime dateTimeCreated;

    @Column(name = "date_time_application_deadline", nullable = false)
    private LocalDateTime dateTimeApplicationDeadline;

    @Column(name = "date_time_start", nullable = false)
    private LocalDateTime dateTimeStart;

    @Column(name = "places", nullable = false)
    private Integer places;

    @Column(name = "is_remote", nullable = false)
    private Boolean isRemote = false;

    @Column(name = "address_line_1", nullable = false, length = Integer.MAX_VALUE)
    private String addressLine1;

    @Column(name = "address_line_2", length = Integer.MAX_VALUE)
    private String addressLine2;

    @Column(name = "city", nullable = false, length = Integer.MAX_VALUE)
    private String city;

    @Column(name = "country", nullable = false, length = Integer.MAX_VALUE)
    private String country;

    @Column(name = "picture", length = Integer.MAX_VALUE)
    private String picture;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;



}
