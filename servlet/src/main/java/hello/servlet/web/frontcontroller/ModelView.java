package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

// 서블릿 종속성을 제거하기 위해 모델을 직접 만들고
// 추가로 view 의 논리 이름을 전달하는 객체
// setAttribute()나 논리 이름을 물리적 이름으로 바꿔주는 작업은 프론트 컨틀롤러에서 진행
public class ModelView {
    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
