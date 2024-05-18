package sopt.hackathon.hakka.service;


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
import sopt.hackathon.hakka.domain.Question;
import sopt.hackathon.hakka.domain.Wish;
import sopt.hackathon.hakka.repository.FinalWishRespository;
import sopt.hackathon.hakka.repository.MemberRepository;
import sopt.hackathon.hakka.repository.QuestionRepository;
import sopt.hackathon.hakka.repository.WishRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinalWishService {
    private final MemberRepository memberRepository;
    private final WishRepository wishRepository;

    public List<FinalWishResponseDto> getFinalWishes(Long memberId){
    private final QuestionRepository questionRepository;
    private final FinalWishRespository finalWishRespository;
    @Transactional
    public void postFinalWish(Long memberId, Long questionId) {
        Member member = memberRepository.findMemberById(memberId);
        Question question = questionRepository.findQuestionById(questionId);
        List<Wish> wishes = wishRepository.findAllByQuestionId(question.getQuestionId());

        wishes.forEach(wish -> {
            finalWishRespository.save(FinalWish.create(member, wish));
            System.out.println(member);
            System.out.println(wish);
        });
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
