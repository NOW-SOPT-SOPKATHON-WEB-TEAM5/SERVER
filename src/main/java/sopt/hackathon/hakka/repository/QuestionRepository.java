package sopt.hackathon.hakka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.hackathon.hakka.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
