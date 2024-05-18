package sopt.hackathon.hakka.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.hackathon.hakka.dto.response.QuestionResponseDto;
import sopt.hackathon.hakka.repository.QuestionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    @Transactional(readOnly = true)
    public QuestionResponseDto getQuestion(Long questionId) {
        System.out.println(questionId);
        return QuestionResponseDto.of(questionRepository.findQuestionById(questionId));
    }
}
