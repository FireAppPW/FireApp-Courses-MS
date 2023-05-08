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

    @EmbeddedId
    private AppliedUserId id;

    @Column(name = "user_full_name", nullable = false, length = Integer.MAX_VALUE)
    private String userFullName;

    @Column(name = "user_department_name", nullable = false, length = Integer.MAX_VALUE)
    private String userDepartmentName;

    @Column(name = "date_time_applied", nullable = false)
    private LocalDateTime dateTimeApplied;
}
