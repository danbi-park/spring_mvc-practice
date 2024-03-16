package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    // ModelView 객체를 사용하여
    // 서블릿 기술을 몰라도 동작할 수 있도록 했으며 - 서블릿 종속성 제거
    // 뷰의 논리 이름만 전달하면 프론터 컨틀롤러에서 앞,뒤로 붙여서 뷰를 호출한다. - 뷰 이름 중복 제거
    ModelView process(Map<String, String> paramMap);
    //여기서 paramMap은 프론트 컨트롤러에서 요청 파라미터를 전달 받아 담는 객체임
}
