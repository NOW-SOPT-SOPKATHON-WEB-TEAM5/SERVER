package sopt.hackathon.hakka.dto.response;

import sopt.hackathon.hakka.domain.Question;

public record QuestionResponseDto(
        Long question_id,
        String content
) {
    public static QuestionResponseDto of(Question question){
        return new QuestionResponseDto(question.getQuestionId(), question.getContent());
    }
}
