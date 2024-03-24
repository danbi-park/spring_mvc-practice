package hello.itemservice.domain.item;

import lombok.Data;

// 지금은 연습이지만, @Data 를 사용할 땐 특히 핵심 도메인 모델에서는 예측 못한 일이 발생할 수 있어
// 웬만하면 @Getter와 @Setter 정도만 분리해서 사용하는게 좋다.
@Data
public class Item {

    private Long id;
    private String itemName;

    // int 말고 Integer를 사용하여 null 값도 저장 가능하도록 한다.
    // 기본형일 경우 0으로 무조건 초기화를 해줘야하기 때문.
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
