package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Repository 안에 @Component 가 있어서 컴포넌트 스캔 대상이 될 수 있다.
@Repository
public class ItemRepository {

    // static에 주의! 연습용으로 싱글톤을 사용하기 위함.
    private static final Map<Long, Item> store = new HashMap<>(); //실제는 hashmap x
    // 실무에서는 HashMap에 여러 스레드가 접속 가능하기 때문에 사용하고 싶으면 ConcurrentHashMap<>()을 사용하여
    // ConcurrentHashMap 을 사용하면 읽기 작업에는 여러 쓰레드가 동시에 읽을 수 있지만, 쓰기 작업에는 Lock을 사용하여 동시성 문제를 보완합니다.

    private static long sequence = 0L; //이것도 실무에서는 AtomicLong 사용하여 동시성 문제를 방지합니다.

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values()); // ArrayList<>로 감싸면 실제 store에 영향을 주지 않고, 형변환도 안해도 됨
    }

    public void update(Long itemId, Item updateParam) { // updateDto 따로 만드는게 나음. 중복이나 명확이냐 그 중에서 명확이 더 중요함.
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }

}
