package v.inc.brainconserver.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import v.inc.brainconserver.domain.Question;
import v.inc.brainconserver.domain.Test;
import v.inc.brainconserver.repository.QuestionRepository;
import v.inc.brainconserver.repository.TestRepository;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestionToTest(Long testId, String questionText, String correctAnswer) {
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new EntityNotFoundException("Test not found with id: " + testId));

        Question question = new Question();
        question.setTest(test);
        question.setQuestionText(questionText);
        question.setCorrectAnswer(correctAnswer);

        return questionRepository.save(question);
    }

    @Override
    public List<Question> getQuestionsByTestId(Long testId) {
        return questionRepository.findByTestId(testId);
    }

    @Override
    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + questionId));
    }

    @Override
    public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }
}