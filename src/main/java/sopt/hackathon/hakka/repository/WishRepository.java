package sopt.hackathon.hakka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sopt.hackathon.hakka.domain.Wish;
import sopt.hackathon.hakka.dto.type.ErrorCode;
import sopt.hackathon.hakka.exception.CustomException;

import java.util.List;

public interface WishRepository extends JpaRepository<Wish, Long> {
    default Wish findWishById(Long id) {
        return findById(id)
                .orElseThrow(
                        () -> new CustomException(ErrorCode.NOT_FOUND_WISH)
                );
    }
    @Query("SELECT w FROM Wish w WHERE w.question.questionId = :questionId")
    List<Wish> findAllByQuestionId(@Param("questionId") Long questionId);
}
