package sopt.hackathon.hakka.dto.request;

import java.util.List;

public class FinalWishDeleteRequestDto {
    private List<Long> wishIds;

    // Getter and Setter
    public List<Long> getWishIds() {
        return wishIds;
    }

    public void setWishIds(List<Long> wishIds) {
        this.wishIds = wishIds;
    }
}
