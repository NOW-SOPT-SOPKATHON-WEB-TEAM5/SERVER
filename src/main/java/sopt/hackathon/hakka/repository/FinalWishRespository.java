package sopt.hackathon.hakka.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt.hackathon.hakka.domain.FinalWish;
import sopt.hackathon.hakka.domain.Member;
import sopt.hackathon.hakka.domain.Wish;
import sopt.hackathon.hakka.dto.type.ErrorCode;
import sopt.hackathon.hakka.exception.CustomException;

public interface FinalWishRespository extends JpaRepository<FinalWish, Long> {
    List<FinalWish> findAllByMember(Member member);

    Optional<FinalWish> findByMemberAndWish(Member member, Wish wish);

    default FinalWish findFinalWishByMemberAndWish(Member member, Wish wish){
        return findByMemberAndWish(member, wish)
                .orElseThrow(
                        () -> new CustomException(ErrorCode.NOT_FOUND_WISH)
                );
    }
}
