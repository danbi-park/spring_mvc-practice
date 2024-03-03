package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    /**
     * @param paramMap
     * @param model
     * @return viewName
     * v4에선 모델도 파라미터로 전달되도록 수정되었다.
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
