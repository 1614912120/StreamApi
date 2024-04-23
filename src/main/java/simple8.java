import java.beans.Customizer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * ClassName: simple8
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author R
 * @Create 2024/4/21 11:59
 * @Version 1.0
 */
public class simple8 {
    public static void main(String[] args) {
        filter(List.of(1, 2, 3, 4, 5, 6),(Integer number) -> (number & 1) == 0);
        List<String> map = map(List.of(1, 2, 3, 4, 5, 6), (Integer number) -> String.valueOf(number));
        System.out.println(map);
        consume(List.of(1, 2, 3, 4, 5, 6),number-> System.out.println(number));

        List<Integer> supply = supply(5, () -> ThreadLocalRandom.current().nextInt());
        System.out.println(supply);
    }

    //有参数 返回布尔
    static List<Integer> filter(List<Integer> list,Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : list) {
            // 筛选：判断是否是偶数，但以后可能改变筛选规则
            if(predicate.test(number)) {
                result.add(number);
            }
        }
        return result;

        /*
            (Integer number) -> (number & 1) == 0
         */
    }

    //有参数有返回值
    //（Integer number）->String.valueOf(number)
    static List<String> map(List<Integer> list, Function<Integer,String> function) {
        List<String> result = new ArrayList<>();
        for (Integer number : list) {
            // 转换：将数字转为字符串，但以后可能改变转换规则
            result.add(function.apply(number));
        }
        return result;
    }

    //有参数 无返回值
    static void consume(List<Integer> list, Consumer<Integer> consumer) {
        for (Integer number : list) {
            // 消费：打印，但以后可能改变消费规则
            consumer.accept(number);
        }
    }

    //无参数有返回值
    static List<Integer> supply(int count, Supplier<Integer> supplier) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // 生成：随机数，但以后可能改变生成规则
            result.add(supplier.get());
        }
        return result;
    }
}
