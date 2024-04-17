package v.inc.brainconserver.service;

import v.inc.brainconserver.domain.Question;

import java.util.List;

public interface QuestionService {
    Question addQuestionToTest(Long testId, String questionText, String correctAnswer);

    List<Question> getQuestionsByTestId(Long testId);

    Question getQuestionById(Long questionId);

    void deleteQuestion(Long questionId);
}
