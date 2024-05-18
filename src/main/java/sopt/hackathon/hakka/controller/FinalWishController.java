package sopt.hackathon.hakka.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.hackathon.hakka.dto.common.ApiResponse;
import sopt.hackathon.hakka.dto.request.FinalWishDeleteRequestDto;
import sopt.hackathon.hakka.dto.response.FinalWishResponseDto;
import org.springframework.web.bind.annotation.*;
import sopt.hackathon.hakka.dto.common.ApiResponse;
import sopt.hackathon.hakka.service.FinalWishService;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class FinalWishController {
    private final FinalWishService finalWishService;

    @GetMapping("/finalWishes")
    public ApiResponse<List<FinalWishResponseDto>> getFinalWishes(
            @RequestHeader("memberId") Long memberId
    ){
        return ApiResponse.ok(finalWishService.getFinalWishes(memberId));
    }

    @PostMapping("/finalWishes/{questionId}")
    public ApiResponse<Void> postFinalWish(
      @RequestHeader Long memberId,
      @PathVariable Long questionId
    ){
        finalWishService.postFinalWish(memberId, questionId);
        return ApiResponse.ok(null);
    }

    @DeleteMapping("/finalWishes")
    public ApiResponse<Void> deleteFinalWishes(
            @RequestHeader("memberId") Long memberId,
            @RequestBody FinalWishDeleteRequestDto finalWishDeleteRequestDto
    ) {
        finalWishService.deleteFinalWishes(memberId, finalWishDeleteRequestDto);
        return ApiResponse.ok(null);
    }

}
