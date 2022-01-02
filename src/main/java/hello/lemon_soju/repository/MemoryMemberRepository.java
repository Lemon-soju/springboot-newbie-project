package hello.lemon_soju.repository;

import hello.lemon_soju.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // member 인스턴스에 id값 입력
        store.put(member.getId(), member); // (id, member) 값 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // Null일 수도 있으므로 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // store member값들 중에서
                .filter(member -> member.getName().equals(name)) // name이 같은 값들 중에서
                .findAny(); // 한 개의 값이라도 있으면 Optional로 감싸서 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
