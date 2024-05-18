package sopt.hackathon.hakka.controller;


import java.util.List;
import lombok.AccessLevel;
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
import sopt.hackathon.hakka.service.FinalWishService;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping
public class FinalWishController {

    private final FinalWishService finalWishService;
    @GetMapping("/finalWishes")
    public ApiResponse<List<FinalWishResponseDto>> getFinalWishes(
            @RequestHeader("memberId") Long memberId
    ){
        return ApiResponse.ok(finalWishService.getFinalWishes(memberId));
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
