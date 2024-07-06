package gift.wishlist;

import gift.user.Member;
import gift.user.MemberResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishlistController {

    @GetMapping("/wish")
    public Member wish(@MemberResolver Member member) {
        return member;
    }
}
