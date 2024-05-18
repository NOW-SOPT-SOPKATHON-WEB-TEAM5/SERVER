package sopt.hackathon.hakka.dto.response;

import java.util.List;
import sopt.hackathon.hakka.domain.FinalWish;

public record FinalWishResponseDto(Long wishId, String content) {
    public static List<FinalWishResponseDto> findAll(List<FinalWish> finalWishList){
        List<FinalWishResponseDto> list = finalWishList.stream().map(FinalWishResponseDto::of).toList();
        return list;
    }

    public static FinalWishResponseDto of (FinalWish finalWish){
        return new FinalWishResponseDto(finalWish.getWish().getWishId(), finalWish.getWish().getContent());
    }
}
