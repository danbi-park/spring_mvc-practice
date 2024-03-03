package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    // 핸들러 어댑터, 핸들러를 처리할 수 있는 핸들러 어댑터를 조회한다.
    // boolean 타입으로 어댑터가 해당 컨트롤러를 처리할 수 있는지 판단 후 true/false를 반환한다.
    // 여기서 아래 Object 핸들러는 컨트롤러의 더 넓은 범위라고 생각하면 된다.
    // 꼭 컨트롤러의 개념 뿐만 아니라 어떠한 것이든 해당 어댑터가 있다면 처리 가능하기 때문이다.
    boolean supports(Object handler);

    // 실제 컨트롤러를 호출하고 ModelView를 반환해야한다.
    // 호출한 컨트롤러가 ModelView를 반환하지 못한다 해도 어댑터가 직접 생성해서라도 반환해야한다.
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
