package sopt.hackathon.hakka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.hackathon.hakka.domain.Wish;

public interface WishRepository extends JpaRepository<Wish, Long> {
}
