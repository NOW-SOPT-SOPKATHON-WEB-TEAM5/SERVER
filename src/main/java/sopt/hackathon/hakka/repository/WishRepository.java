package sopt.hackathon.hakka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.hackathon.hakka.domain.Member;
import sopt.hackathon.hakka.domain.Wish;
import sopt.hackathon.hakka.dto.type.ErrorCode;
import sopt.hackathon.hakka.exception.CustomException;

public interface WishRepository extends JpaRepository<Wish, Long> {
    default Wish findWishById(Long id) {
        return findById(id)
                .orElseThrow(
                        () -> new CustomException(ErrorCode.NOT_FOUND_MEMBER)
                );
    }
}
