package sopt.hackathon.hakka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.hackathon.hakka.domain.Question;
import sopt.hackathon.hakka.dto.type.ErrorCode;
import sopt.hackathon.hakka.exception.CustomException;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    default Question findQuestionById(Long id) {
        return findById(id)
                .orElseThrow(
                        () -> new CustomException(ErrorCode.NOT_FOUND_QUESTION)
                );
    }
}
