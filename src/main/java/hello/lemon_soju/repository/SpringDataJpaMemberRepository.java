package hello.lemon_soju.repository;

import hello.lemon_soju.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 인터페이스를 만들고 extends로 JpaRepository를 상속받으면 스프링이 인터페이스를 스트링 빈에 자동으로 등록한다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository { // 인터페이스가 인터페이스를 받을 때는 extends 사용

    // 구현이 필요 없는 이유 -> JpaRepository에 이미 다 메소드가 등록되어 있다.
    @Override
    Optional<Member> findByName(String name);
}
