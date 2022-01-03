package hello.lemon_soju.repository;

import hello.lemon_soju.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em; // EntityManager을 통해 JPA가 동작

    public JpaMemberRepository(EntityManager em) { // 스프링이 자동으로 EntityManager를 생성하므로 생성자를 통해 인젝션 받으면 됨
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id); // 조회할 타입, 식별자 넘겨주면 됨
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() { // Ctrl + Shift + N -> inline 한줄로 합쳐줌
        // sql이랑 다르게 테이블이 아닌 객체를 통해서 값을 가져옴
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
