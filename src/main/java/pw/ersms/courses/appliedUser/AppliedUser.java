package pw.ersms.courses.appliedUser;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "\"AppliedUsers\"")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppliedUser {

    @Id
    @SequenceGenerator(
            name = "AppliedUser_id_seq",
            sequenceName = "AppliedUser_id_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "AppliedUser_id_seq"
    )
    private Integer courseId, userId;

    @Column(name = "user_full_name", nullable = false, length = Integer.MAX_VALUE)
    private String userFullName;

    @Column(name = "user_department_name", nullable = false, length = Integer.MAX_VALUE)
    private String userDepartmentName;

    @Column(name = "date_time_applied", nullable = false)
    private LocalDateTime dateTimeApplied;
}
