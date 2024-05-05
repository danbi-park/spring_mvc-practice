package hello.itemservice.validation;

import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject() {
        // 제일 디테일 한 것부터 만들어줌
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodesResolverField() {
        // 제일 디테일 한 것부터 만들어줌
        // BindingResult.rejectValue("itemValue", "required")
        // rejectValue가 내부적으로 codesResolver를 호출한다.
        // FieldError 를 만들 때 codesResolver에서 만든걸 codes 파라미터로 넘긴다.

        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        assertThat(messageCodes).containsExactly(
                "required.item.itemName", // 가장 자세하게
                "required.itemName", // 덜 자세하게 -> 객체 이름 생략
                "required.java.lang.String", // 타입
                "required"
        );
    }

}
