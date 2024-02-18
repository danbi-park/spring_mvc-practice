package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
* HTTP 요청 : GET 쿼리 파라미터 방식
* - 쿼리 파라미터는 다음과 같이 Url 뒤에 "?" 를 붙여서 시작하고 "key=value" 로 작성하며 "&" 로 구분합니다.
* 예) http://localhost:8080/request-param?username=hello&age=20
*
* */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 전체 파라미터를 조회할 때 iterator를 사용하여 조회
        System.out.println("[전체 파라미터 조회] - start");
        req.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + ": " + req.getParameter(paramName)));
        // 위에서 paramName은 "key" 이고 이 값은 req.getParameter("key")로 가져옵니다.

        // 2. 단일 파라미터 조회
        System.out.println("[단일 파라미터 조회]");
        String username = req.getParameter("username");
        String age = req.getParameter("age");

        System.out.println("age = " + age);
        System.out.println("username = " + username);
        System.out.println();

        // 3. 중복 파라미터 조회 -> getParameterValues()
        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = req.getParameterValues("username"); // 참고로 중복일 때에 getParameter()쓰면 첫번째 값을 반환합니다.

        for(String name : usernames) {
            System.out.println("username = " + name);
        }

        // 응답 메시지 작성 (화면에 표시)
        resp.getWriter().write("ok");

    }
}
