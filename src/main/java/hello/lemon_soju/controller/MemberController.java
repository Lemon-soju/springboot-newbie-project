package hello.lemon_soju.controller;

import hello.lemon_soju.domain.Member;
import hello.lemon_soju.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller // 스프링이 실행될 때마다 컨테이너의 Bean을 생성한다. Controller는 컨테이너에 Bean 형태로 넣어서 관리한다.
public class MemberController {
    private final MemberService memberService;
    @Autowired // Autowired를 통해 memberService 객체를 가져와서 현재 Controller와 연결해줌
    // Controller와 Service를 연결해줌 -> Dependency Injection
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form) { // 스프링이 알아서 넘어온 name을 form의 name에 저장
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}