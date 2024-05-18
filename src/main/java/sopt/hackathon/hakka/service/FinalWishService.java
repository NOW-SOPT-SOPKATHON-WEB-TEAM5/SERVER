package sopt.hackathon.hakka.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.hackathon.hakka.domain.FinalWish;
import sopt.hackathon.hakka.domain.Member;
import sopt.hackathon.hakka.domain.Wish;
import sopt.hackathon.hakka.dto.request.FinalWishDeleteRequestDto;
import sopt.hackathon.hakka.dto.response.FinalWishResponseDto;
import sopt.hackathon.hakka.repository.FinalWishRespository;
import sopt.hackathon.hakka.repository.MemberRepository;
import sopt.hackathon.hakka.repository.WishRepository;

@Service
@RequiredArgsConstructor
public class FinalWishService {
    private final FinalWishRespository finalWishRespository;
    private final MemberRepository memberRepository;
    private final WishRepository wishRepository;

    public List<FinalWishResponseDto> getFinalWishes(Long memberId){
        Member member = memberRepository.findMemberById(memberId);
        return FinalWishResponseDto.findAll(finalWishRespository.findAllByMember(member));
    }

    @Transactional
    public void deleteFinalWishes(Long memberId, FinalWishDeleteRequestDto finalWishDeleteRequestDto){
        Member member = memberRepository.findMemberById(memberId);
        List<Long> list = finalWishDeleteRequestDto.getWishIds();
        for (Long finalWishId : list) {
            Wish wish = wishRepository.findWishById(finalWishId);
            FinalWish finalWish = finalWishRespository.findFinalWishByMemberAndWish(member, wish);
            finalWishRespository.delete(finalWish);
        }
    }
}
