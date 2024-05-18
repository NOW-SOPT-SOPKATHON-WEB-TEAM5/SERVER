package sopt.hackathon.hakka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.hackathon.hakka.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
