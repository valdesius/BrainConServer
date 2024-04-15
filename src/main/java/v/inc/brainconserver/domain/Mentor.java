package v.inc.brainconserver.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "mentors")

public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    private String expertiseArea;

    @OneToMany(mappedBy = "mentor")
    private List<Course> coursesInstructed;

    @OneToMany(mappedBy = "createdByMentor")
    private List<Test> testsCreated;
}
