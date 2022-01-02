package hello.lemon_soju;

import hello.lemon_soju.repository.MemberRepository;
import hello.lemon_soju.repository.MemoryMemberRepository;
import hello.lemon_soju.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Configuration과 Bean을 사용하면 Bean에 등록할 수 있음
public class SpringConfig {
    @Bean // 스트링 빈에 등록
    public MemberService memberService() {
        return new MemberService(memberRepository()); // 같은 클래스이므로 Autowired 사용안하는 것으로 추측
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository(); // 인터페이스는 new가 안되므로 구현체 생성
    }
}
