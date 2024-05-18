package sopt.hackathon.hakka.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.hackathon.hakka.dto.common.ApiResponse;
import sopt.hackathon.hakka.service.FinalWishService;

@RestController
@RequiredArgsConstructor

public class FinalWishController {
    private final FinalWishService finalWishService;

    @PostMapping("/finalWishes/{questionId}")
    public ApiResponse<Void> postFinalWish(
      @RequestHeader Long memberId,
      @PathVariable Long questionId
    ){
        finalWishService.postFinalWish(memberId, questionId);
        return ApiResponse.ok(null);
    }

}
