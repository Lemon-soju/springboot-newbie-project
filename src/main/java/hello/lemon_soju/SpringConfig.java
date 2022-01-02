package hello.lemon_soju;

import hello.lemon_soju.repository.JdbcMemberRepository;
import hello.lemon_soju.repository.MemberRepository;
import hello.lemon_soju.repository.MemoryMemberRepository;
import hello.lemon_soju.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration // Configuration과 Bean을 사용하면 Bean에 등록할 수 있음
public class SpringConfig {

    private DataSource dataSource;

    @Autowired // Datasource는 스프링에서 자동으로 @Bean으로 등록하므로 Autowired로 사용 가능
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean // 스트링 빈에 등록
    public MemberService memberService() {
        return new MemberService(memberRepository()); // 같은 클래스이므로 Autowired 사용안하는 것으로 추측
    }
    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository(); // 인터페이스는 new가 안되므로 구현체 생성
        return new JdbcMemberRepository(dataSource);

    }
}
