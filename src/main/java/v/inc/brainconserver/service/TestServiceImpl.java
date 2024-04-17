package v.inc.brainconserver.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import v.inc.brainconserver.domain.Course;
import v.inc.brainconserver.domain.Mentor;
import v.inc.brainconserver.domain.Question;
import v.inc.brainconserver.domain.Test;
import v.inc.brainconserver.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getQuestionsByTestId(Long testId) {
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new EntityNotFoundException("Test not found with id: " + testId));
        return test.getQuestions();
    }

    @Override
    public double submitTestAndGetScore(Long studentId, Long testId, List<String> studentAnswers) {
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new EntityNotFoundException("Test not found with id: " + testId));

        List<Question> questions = test.getQuestions();
        double totalScore = 0;

        for (int i = 0; i < questions.size() && i < studentAnswers.size(); i++) {
            if (questions.get(i).getCorrectAnswer().equals(studentAnswers.get(i))) {
                totalScore += 1; // assuming each question carries 1 point
            }
        }

        double percentageScore = (totalScore / questions.size()) * 100;

        // Save student's answers and score (for record keeping or analysis)
        saveStudentAnswersAndScore(studentId, test, studentAnswers, percentageScore);

        return percentageScore;
    }

    @Override
    public Test createTest(String testName, Course course, List<Question> questions) {
        Test test = new Test();
        test.setTitle(testName);
        test.setCourse(course);

        List<Question> savedQuestions = questionRepository.saveAll(questions);
        test.setQuestions(savedQuestions);

        return testRepository.save(test);
    }

    private void saveStudentAnswersAndScore(Long studentId, Test test, List<String> studentAnswers, double score) {
        // Save student's answers and score to database for record keeping or analysis
        // You can implement this method based on your application's requirements
    }
}