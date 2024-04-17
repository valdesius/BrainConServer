package v.inc.brainconserver.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import v.inc.brainconserver.domain.Student;
import v.inc.brainconserver.domain.Test;
import v.inc.brainconserver.domain.User;
import v.inc.brainconserver.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student enrollStudent(User user, String major) {
        Student student = new Student();
        student.setUser(user);
        student.setMajor(major);
        return studentRepository.save(student);
    }

    @Override
    public List<Test> getTestsTakenByStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + studentId));
        return student.getTestsTaken();
    }
}
