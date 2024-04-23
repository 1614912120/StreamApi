package test3;

import java.util.stream.Stream;

/**
 * ClassName: C05ConcatSplitTest
 * Package: test3
 * Description:
 *
 * @Author R
 * @Create 2024/4/22 13:19
 * @Version 1.0
 */
public class C05ConcatSplitTest {
    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1, 2, 3);
        Stream<Integer> s2 = Stream.of(4, 5, 1, 2);

        Stream.concat(s1, s2).forEach(System.out::println);
    }
}
