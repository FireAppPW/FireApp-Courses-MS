package pw.ersms.courses.appliedUser;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class AppliedUserId implements Serializable {
    private static final long serialVersionUID = -5737736616833641513L;

    @NotNull
    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(obj == null || Hibernate.getClass(this) != Hibernate.getClass(obj))
            return false;
        AppliedUserId entity = (AppliedUserId) obj;

        return Objects.equals(this.courseId, entity.courseId) &&
                Objects.equals(this.userId, entity.userId);

    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, userId);
    }
}
