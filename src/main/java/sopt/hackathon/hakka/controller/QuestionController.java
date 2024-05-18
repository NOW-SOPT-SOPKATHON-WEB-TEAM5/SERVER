package sopt.hackathon.hakka.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import sopt.hackathon.hakka.dto.common.ApiResponse;
import sopt.hackathon.hakka.dto.response.QuestionResponseDto;
import sopt.hackathon.hakka.service.QuestionService;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/question/{questionId}")
    public ApiResponse<QuestionResponseDto> getQuestion(
            @PathVariable Long questionId
    ){
        return ApiResponse.ok(questionService.getQuestion(questionId));
    }
}
