/**
 * ClassName: test
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author R
 * @Create 2024/4/21 9:38
 * @Version 1.0
 */
public class test {
    static int add(int a, int b) {
        return a + b;
    }
    interface Lambda {
        int calculate(int a,int b);
    }
    static Lambda add = (a, b) -> a+b;

    public static void main(String[] args) {
        System.out.println(add.calculate(1,2));
    }
}
