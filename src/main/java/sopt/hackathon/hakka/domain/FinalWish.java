package sopt.hackathon.hakka.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "finalWish")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FinalWish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finalWish_id")
    private Long finalWishId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wish_id")
    private Wish wish;

    private FinalWish(Member member, Wish wish) {
        this.member = member;
        this.wish = wish;
    }
    public static FinalWish create(Member member, Wish wish) {
        return new FinalWish(member, wish);
    }
}
