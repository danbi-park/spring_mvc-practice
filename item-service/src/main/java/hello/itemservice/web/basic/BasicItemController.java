package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

//    @PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                       @RequestParam int price,
                       @RequestParam Integer quantity,
                       Model model) {

        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);

        model.addAttribute("item", item); //상세 페이지로 이동시키기 위함.

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item, Model model) {

        itemRepository.save(item);
//      model.addAttribute("item", item); //자동 추가, 생략 가능. ModelAttribute의 name 속성으로 모델에 자동으로 담김

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item) {
        itemRepository.save(item); //똑같이 객체 클래스 이름에서 첫 글자를 소문자로 하여 모델에 담김
        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV4(Item item) {
        itemRepository.save(item);
        return "basic/item";
    }

    // 새로고침 문제를 방지->  PRG
//    @PostMapping("/add")
    public String addItemV5(Item item) {
        itemRepository.save(item);
        return "redirect:/basic/items/" + item.getId();
    }

    // add 같은 urlㅣ잠ㄴ 하나는 뷰, 하나는 요청폼으로 METHOD 방식의 GET, POST로 구분해준다.
    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes) {
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);

//        PathVariable에 있는거 그대로 쓸 수 있음.
        //상태코드 302 - 리다이렉트
        return "redirect:/basic/items/{itemId}";
    }

    /**
     * 테스트용 데이터 추가
     * 이 어노테이션이 붙은 메서드는 해당 클래스의 인스턴스가 생성된 이후에 실행됩니다. 주로 초기화 작업에 사용되며,
     * Spring 프레임워크에서 빈(Bean)이 생성된 후 추가적인 초기화 작업을 수행하는 데 많이 활용됩니다.
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }

}

