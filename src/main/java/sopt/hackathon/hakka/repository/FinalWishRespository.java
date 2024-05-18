package sopt.hackathon.hakka.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt.hackathon.hakka.domain.FinalWish;
import sopt.hackathon.hakka.domain.Member;

public interface FinalWishRespository extends JpaRepository<FinalWish, Long> {
    List<FinalWish> findAllByMember(Member member);
}
