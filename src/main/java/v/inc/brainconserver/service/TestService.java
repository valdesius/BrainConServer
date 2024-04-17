package v.inc.brainconserver.service;

import v.inc.brainconserver.domain.Course;
import v.inc.brainconserver.domain.Question;
import v.inc.brainconserver.domain.Test;

import java.util.List;

public interface TestService {
    List<Question> getQuestionsByTestId(Long testId);

    double submitTestAndGetScore(Long studentId, Long testId, List<String> studentAnswers);

    Test createTest(String testName, Course course, List<Question> questions);

}