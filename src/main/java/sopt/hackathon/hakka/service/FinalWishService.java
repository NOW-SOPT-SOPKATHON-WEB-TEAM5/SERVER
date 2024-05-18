package sopt.hackathon.hakka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.hackathon.hakka.domain.FinalWish;
import sopt.hackathon.hakka.domain.Member;
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
}
