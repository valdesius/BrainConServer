package v.inc.brainconserver.service;

import v.inc.brainconserver.domain.Student;
import v.inc.brainconserver.domain.Test;
import v.inc.brainconserver.domain.User;

import java.util.List;

public interface StudentService {
    Student enrollStudent(User user, String major);

    List<Test> getTestsTakenByStudent(Long studentId);
}
