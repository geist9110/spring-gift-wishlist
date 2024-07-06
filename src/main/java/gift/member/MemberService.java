package gift.member;

import gift.exception.FailedLoginException;
import gift.token.JwtProvider;
import org.springframework.stereotype.Component;

@Component
public class MemberService {

    public final MemberRepository memberRepository;
    public final JwtProvider jwtProvider;

    public MemberService(
        MemberRepository memberRepository,
        JwtProvider jwtProvider
    ) {
        this.memberRepository = memberRepository;
        this.jwtProvider = jwtProvider;
    }

    public String register(Member member) {
        if (memberRepository.existMemberByEmail(member.email())) {
            throw new IllegalArgumentException("User already exists");
        }

        memberRepository.addMember(member);
        return jwtProvider.generateToken(member);
    }

    public String login(Member member) {
        if (!memberRepository.existMemberByEmail(member.email())) {
            throw new FailedLoginException("User does not exist");
        }

        Member findMember = memberRepository.findMemberByEmail(member.email());

        if (!findMember.password().equals(member.password())) {
            throw new FailedLoginException("Wrong password");
        }

        return jwtProvider.generateToken(member);
    }
}
