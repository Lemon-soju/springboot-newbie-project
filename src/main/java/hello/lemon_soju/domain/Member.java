package hello.lemon_soju.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // JPA가 관리하는 Entity이다.
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key, 키 생성 전략

    private Long id; // 데이터를 구분하기 위해 시스템이 정하는 id 값

    // 만약 데이터베이스 username을 맵핑하고 싶으면 @Column(name = "username") 입력
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

