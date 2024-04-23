import java.util.Map;
import java.util.stream.Stream;

/**
 * ClassName: simple9
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author R
 * @Create 2024/4/21 12:37
 * @Version 1.0
 */
public class simple9 {
    public static void main(String[] args) {
        Util util = new UtilExt();
        util.hiOrder(Stream.of(
                new Student("张无忌", "男"),
                new Student("周芷若", "女"),
                new Student("宋青书", "男")
        ));
    }

    record Student(String name, String sex) { }

    static class Util {
        private boolean isMale(Student stu) {
            return stu.sex().equals("男");
        }
        public boolean isFemale(Student stu) {
            return stu.sex().equals("女");
        }
        // 过滤男性学生并打印
        void hiOrder(Stream<Student> stream) {
            stream
//                    .filter(stu->this.isMale(stu))
                    .filter(this::isMale)
                    .forEach(System.out::println);
        }
    }

    static class UtilExt extends Util {

        // 过滤女性学生并打印
        void hiOrder(Stream<Student> stream) {
           stream.filter(super::isFemale).forEach(System.out::println);
        }
    }
}
