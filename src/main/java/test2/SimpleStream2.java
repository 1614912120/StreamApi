package test2;

import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * ClassName: simple11
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author R
 * @Create 2024/4/22 10:59
 * @Version 1.0
 */
public class SimpleStream2<T> {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        System.out.println(SimpleStream2.of(list).reduce(0, Integer::sum));
        System.out.println(SimpleStream2.of(list).reduce(Integer.MAX_VALUE, Integer::min));
        System.out.println(SimpleStream2.of(list).reduce(Integer.MIN_VALUE, Integer::max));
    }

    public static <T> SimpleStream2<T> of(Collection<T> collection) {
        return new SimpleStream2<>(collection);
    }

    private Collection<T> collection;

    private SimpleStream2(Collection<T> collection) {
        this.collection = collection;
    }


    //o代表初始值
    public T reduce(T o,BinaryOperator<T> operator) {
        T p = o; // 上次合并结果
        for (T t : collection) {  //本次遍历元素
            p = operator.apply(p, t);
        }
        return p;
    }

}
