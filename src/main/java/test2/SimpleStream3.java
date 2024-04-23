package test2;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * ClassName: SimpleStream3
 * Package: test2
 * Description:
 *
 * @Author R
 * @Create 2024/4/22 11:59
 * @Version 1.0
 */
public class SimpleStream3<T> {
    private Collection<T> collection;

    public SimpleStream3(Collection<T> collection) {
        this.collection = collection;
    }
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        HashSet<Object> collect = SimpleStream3.of(list)
                .collect(HashSet::new, (set, t) -> set.add(t));
        System.out.println(collect);
    }
    public static <T> SimpleStream3<T> of(Collection<T> collection) {
        return new SimpleStream3<>(collection);
    }


    //c代表容器类型 suplier用来创建容器
    public <C> C collect(Supplier<C> supplier, BiConsumer<C,T> consumer) {
        C c = supplier.get();
        for (T t : collection) {
            consumer.accept(c,t); //容器添加元素
        }
        return c;
    }

}
