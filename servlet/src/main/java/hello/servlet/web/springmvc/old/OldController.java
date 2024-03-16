package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @Component 로 Bean 등록
// url에서 아래 등록된 빈 이름을 호출하면 아래 OldController 가 호출된다.
// SpringBoot 가 자동으로 등록하는 HandlerMapping, HadlerAdapter가 다음과 같이 찾는다.
// HandlerMapping(핸들러조회): 우선순위 1 = BeanNameUrlHandlerMapping(스프링 빈의 이름으로 핸들러를 찾는다)가 호출됨.
// HadlerAdapter(핸들러를 실행할 어댑터 조회): 우선순위 2 = Controller 인터페이스(애노테이션 X, 과거에 사용됨)
@Component("/springmvc/old-controller")
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        //아래와 같이 논리적인 이름을 쓰려면 application.properties 에 설정 정보를 등록해야한다.
        return new ModelAndView("new-form");
    }
}
