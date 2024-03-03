package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {

    // MyView를 리턴함으로써 각 컨틀롤러는 복잡하고 중복되는 forward 등을 호출하지 않고 단순히 뷰 이름만 넣고 반환하면 된다.
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
