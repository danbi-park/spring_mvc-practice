package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@RequestMapping이나 @Controller가 클래스 레벨에 붙어 있어야 매핑 정보로 인식한다.

//@Component // 컴포넌트 스캔을 통해 스프링 빈으로 등록(또는 main클래스에서 @Bean 사용하여 등록)
//@RequestMapping
// 스프링 부트 3(스프링 프레임워크6.0) 부터는 클레스 레벨에 @RequestMapping이 있어도 스프링 컨트롤러로 인식하지 않는다. @Controller만 인정
@Controller //하지만 깔끔하게 얘 하나만 쓴다.
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }

}
