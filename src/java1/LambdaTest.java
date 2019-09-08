package java1;


import org.junit.Test;

import java.util.Comparator;

/**
 * LambdaTest:Lambda表达式的使用举例
 *
 * @author zhangxiaoxiang
 * @date 2019/9/8
 */
public class LambdaTest {
    /**
     * 例子1
     */
    @Test
    public void test1() {
        /**
         * 没有使用lambda表达式的写法(其实idea会提示使用)
         */
        //线程的匿名实现类的写法
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是常规写法,匿名实现的写法!");
            }
        };

        r1.run();

        System.out.println("lambda表达式写法*************************");
        //lambda表达式写法
        Runnable r2 = () -> System.out.println("我是jdk8提供的lambda写法");

        r2.run();
    }

    /**
     * 例子2
     */
    @Test
    public void test2() {
        //Comparator用于比较的类
        Comparator<Integer> com1 = new Comparator<Integer>() {
            /**
             * o1比o2大返回1小则返回-1,相等返回0
             * @param o1
             * @param o2
             * @return
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        System.out.println("Lambda表达式的写法(常规一点的)***********************");
        //Lambda表达式的写法(还可以改.idea会提示你)
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);

        int compare2 = com2.compare(32, 21);
        System.out.println(compare2);


        System.out.println("Lambda表达式的写法(方法引用的方式)***********************");
        //方法引用
        Comparator<Integer> com3 = Integer::compare;

        int compare3 = com3.compare(32, 21);
        System.out.println(compare3);
    }

}
