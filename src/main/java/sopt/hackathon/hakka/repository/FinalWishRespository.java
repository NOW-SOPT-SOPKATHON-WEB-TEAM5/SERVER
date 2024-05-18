package sopt.hackathon.hakka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.hackathon.hakka.domain.FinalWish;

public interface FinalWishRespository extends JpaRepository<FinalWish, Long> {
}
