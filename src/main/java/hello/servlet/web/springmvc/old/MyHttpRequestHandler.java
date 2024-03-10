package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @Component로 Bean 등록
// url에서 아래 등록된 빈 이름을 호출하면 아래 MyHttpRequestHandler 가 호출된다.
// HandlerMapping(핸들러조회): 우선순위 1 = BeanNameUrlHandlerMapping(스프링 빈의 이름으로 핸들러를 찾는다)가 호출됨.
// HadlerAdapter(핸들러를 실행할 어댑터 조회): 우선순위 1 = HttpRequestHandler 인터페이스
// OldController에서 implemets한 interface Controller 보다 우선순위가 더 놓기 때문에 먼저 호출된다.
@Component("/springmvc/request-handler")
public class MyHttpRequestHandler implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyHttpRequestHandler.handleRequest");
    }
}
