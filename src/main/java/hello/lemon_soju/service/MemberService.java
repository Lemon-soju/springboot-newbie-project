package hello.lemon_soju.service;

import hello.lemon_soju.domain.Member;
import hello.lemon_soju.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Ctro + Shift + T -> 테스트 만들기
@Transactional // JPA를 사용할 때 항상 Transactional를 사용해야함
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) { // 외부에서 memberRepository를 넣어줌
        this.memberRepository = memberRepository; // 이를 dependency injection이라고 함
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) { // Ctrl + Alt + M -> 메소드 추출
        memberRepository.findByName(member.getName()) // Ctrl + Alt + V -> 자동 변수 생성
                .ifPresent(m -> { // Optional이 제공하는 ifPresent 함수
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}