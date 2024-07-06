package gift.wishlist;

import gift.member.Member;
import gift.member.MemberResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishlistController {

    @GetMapping("/wish")
    public Member wish(@MemberResolver Member member) {
        return member;
    }
}
