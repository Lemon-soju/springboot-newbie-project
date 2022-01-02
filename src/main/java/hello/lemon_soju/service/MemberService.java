package hello.lemon_soju.service;

import hello.lemon_soju.domain.Member;
import hello.lemon_soju.repository.MemberRepository;
import hello.lemon_soju.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Ctro + Shift + T -> 테스트 만들기
@Service // Controller에서 MemberService를 사용하기 위해 선언
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired // MemberController에서 MemberService를 가져오는데 MemberService는 MemberRepository를 가져와야 하므로 Autowired로 연결해줌
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