package test2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
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
public class SimpleStream4<T> {
    private Collection<T> collection;

    public SimpleStream4(Collection<T> collection) {
        this.collection = collection;
    }
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        StringBuilder collect = SimpleStream4.of(list)
                .collect(StringBuilder::new, StringBuilder::append);
        System.out.println(collect);

        //拼接有-
        StringJoiner collect1 = SimpleStream4.of(list)
                .map(t -> String.valueOf(t))
                .collect(() -> new StringJoiner("-"), StringJoiner::add);
        System.out.println(collect1);
    }
    public static <T> SimpleStream4<T> of(Collection<T> collection) {
        return new SimpleStream4<>(collection);
    }
    public <U> SimpleStream4<U> map(Function<T,U> function) {
        ArrayList<U> result = new ArrayList<>();
        for (T t : collection) {
            U u = function.apply(t);
            result.add(u);
        }

        return new SimpleStream4<>(result);
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
