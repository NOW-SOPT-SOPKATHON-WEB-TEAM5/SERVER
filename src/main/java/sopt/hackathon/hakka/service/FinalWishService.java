package sopt.hackathon.hakka.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.hackathon.hakka.domain.FinalWish;
import sopt.hackathon.hakka.domain.Member;
import sopt.hackathon.hakka.dto.response.FinalWishResponseDto;
import sopt.hackathon.hakka.repository.FinalWishRespository;
import sopt.hackathon.hakka.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class FinalWishService {
    private final FinalWishRespository finalWishRespository;
    private final MemberRepository memberRepository;

    public List<FinalWishResponseDto> getFinalWishes(Long memberId){
        Member member = memberRepository.findMemberById(memberId);
        return FinalWishResponseDto.findAll(finalWishRespository.findAllByMember(member));
    }
}
