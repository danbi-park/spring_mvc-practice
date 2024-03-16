package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// *를 사용하여 "/front-controller/v1" 를 포함한 하위 모든 요청은 하위 서블릿에서 받아들인다.
@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    // key: 매핑 url, value: 호출될 컨트롤러
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    // 1. 생성자에서 url과 컨트롤러 지정한다.
    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        // 2. url을 조회하여 호출할 컨트롤러를 찾는다.
        String requestURI = request.getRequestURI();
        ControllerV1 controller = controllerMap.get(requestURI);
        // 3. 컨트롤러가 없으면 404 리턴
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 4. 컨트롤러를 찾으면 해당 컨트롤러를 실행한다.
        controller.process(request, response);
    }
}
