package hello.lemon_soju;

import hello.lemon_soju.repository.*;
import hello.lemon_soju.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration // Configuration과 Bean을 사용하면 Bean에 등록할 수 있음
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) { // 구현체 만들어 놓은게 등록됨
        this.memberRepository = memberRepository;
    }

    @Bean // 스트링 빈에 등록
    public MemberService memberService() {
        return new MemberService(memberRepository); // 같은 클래스이므로 Autowired 사용안하는 것으로 추측
    }
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository(); // 인터페이스는 new가 안되므로 구현체 생성
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
