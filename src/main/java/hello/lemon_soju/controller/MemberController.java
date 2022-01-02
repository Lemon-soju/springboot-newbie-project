package hello.lemon_soju.controller;

import hello.lemon_soju.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 스프링이 실행될 때마다 컨테이너의 Bean을 생성한다. Controller는 컨테이너에 Bean 형태로 넣어서 관리한다.
public class MemberController {
    private final MemberService memberService;

    @Autowired // Autowired를 통해 memberService 객체를 가져와서 현재 Controller와 연결해줌
    // Controller와 Service를 연결해줌 -> Dependency Injection
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}