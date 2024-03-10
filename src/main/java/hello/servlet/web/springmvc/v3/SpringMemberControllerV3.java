package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* MVC 실용적인 방식
* Model 도입
* ViewName 직접 반환 가능
* @RequestParam 사용
* @RequestMapping -> @GapMapping, @PostMapping
* */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    // Method 방식 지정
//    @RequestMapping(value = "/new-form", method = RequestMethod.GET) POST 사용시 405 (unsupported method)
//    @GetMapping("/new-form")


    // 어노테이션 기반 컨트롤러는
    // view 반환 시에 String, mv 둘 다 유연하게 반환 가능
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    // HTTP 요청 파라미터를 @ReqeustParam으로 받을 수 있다.
    // Model 을 받을 수 있다.
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age, // 타입변환도 자동으로 해준다.parsing
            Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @GetMapping
    public String members(Model model) {

        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }
}
